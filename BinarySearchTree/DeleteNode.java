package BinarySearchTree;

public class DeleteNode {
    // Question_Name - Delete Node in a BST
// Problem_Link -  https://leetcode.com/problems/delete-node-in-a-bst/
// Platform - LeetCode


 
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return root;
        if(root.val == key){
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null && root.right!=null){
                return root.right;
            }
            else if(root.left!=null && root.right==null){
                return root.left;
            }
            else{
                TreeNode successor = findSuccessor(root.right);
                swap(root,successor);
                root.right = deleteNode(root.right,key);
                return root;
            }
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            root.left = deleteNode(root.left,key);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode root){
        if(root==null)return null;
        // TreeNode prev = root;
        while(root.left!=null){
            // prev = root;
            root = root.left;
        }
        // prev.left = null;
        return root;
    }

    private void swap(TreeNode root1 , TreeNode root2){
        int temp = root1.val;
        root1.val = root2.val;
        root2.val = temp;
    }
}

/*
Explanation:
Approach 1 (DFS):
Appraoch is simple
If the key is the leaf node then it would be very easy to delete the leaf node we just have to return null.
If the key is not a leaf node:
 1.either left or right subtree would be there, so for that just return the not null subtree.
 2.both left and right subtree are there , so in this we have to first find the sucessor
   and , after  we need to swap the value between the root and successor node and after that recursively delete the successor node bcz it holds the key value now

Time_Complexity - O(logH) H is the height
Space_Complexity - O(logH) recursion stack

 */

