// Question Name - Construct BST from Preorder Traversal.
// Problem Link - https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Platform - Leetcode.

package BinarySearchTree;
//   Definition for a binary tree node.
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

class Solution {
    public int indx;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        indx = 0;
        return helper(preorder , Integer.MAX_VALUE , new int[]{0});

    }
    private TreeNode helper(int[] preorder , int bound , int[] i){

        if(i[0]>=preorder.length || preorder[i[0]]>bound)return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = helper(preorder , root.val , i);
        root.right = helper(preorder , bound , i);
        return root;
    }
}

/**
Explanation:
Approach 1:
Intuition behind it that to maintain a upper bound for both the left and right node of the tree.

for left node upperBound will be root.val
for right node upperBound will be same of root's upperBound.




 */ 