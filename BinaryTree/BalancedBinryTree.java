package BinaryTree;

public class BalancedBinryTree {
    
    // Question_Name -   Balanced Binary Tree
// Problem_link  -   https://leetcode.com/problems/balanced-binary-tree/
// PlatForm - LeetCode


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

    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        int h = height(root);
        return ans;
    }
    private int height(TreeNode root){
        if(root==null)return 0;
        int x = height(root.left);
        int y = height(root.right);
        if(Math.abs(x-y)>1)ans = false;
        return Math.max(x,y)+1;
    } 
}

