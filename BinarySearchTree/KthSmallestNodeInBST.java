// Question_Name -  Kth Smallest Element in a BST
// Problem_Link -   https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Platform - LeetCode 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        int[] ans = new int[]{0};
        // helper(root,k,ans);
        // return ans[0];

        TreeNode node = root;
        while(node!=null){
            if(count == k)return node.val;
            if(node.left == null){
                count+=1;
                if(count==k)return node.val;
                node=node.right;
            }
            else{
                TreeNode predecessor = findPredecessor(node);
                if(predecessor.right == null ){
                    predecessor.right = node;
                    node = node.left;
                }
                else{
                    count+=1;
                    if(count==k)return node.val;
                    predecessor.right = null;
                    node = node.right;
                }

            }
        }
        return -1;
    }
    private void helper(TreeNode root,int k,int[] ans ){

        if(root==null)return ;
       
        helper(root.left,k,ans );
        count+=1;
        if(count==k){
            ans[0] = root.val;
            return;
        }
        helper(root.right,k,ans);
    }
    private TreeNode findPredecessor(TreeNode root){
        if(root.left==null)return root;
        TreeNode curr = root.left;
        while(curr.right!=root && curr.right!=null){
            curr=curr.right;
        }
        return curr;
    }


}

// Explanation:
/**
Approach 1:
The first approach is to do a inorder traversal and pull out the node where the count == k.
Time_Complexity - O(N) as we traverse whole tree in worst case scenerio
Space_Complexity - O(N) recursion stack space .

Approach 2:

The idea is same as inOrder but instead of using the extra recursive stack space we use morris traversal which boils the space complexity from O(N) to (1).

Time_Complexity - O(N)
Space_Complexity - O(1) 


 */