package BinaryTree;

public class Diameter {
    
    // Question_Name - Diameter of Binary Tree
// Problem_Link -  https://leetcode.com/problems/diameter-of-binary-tree/
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

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        int height  = helper(root,diameter);
        return diameter[0];
    }
    private int helper(TreeNode root,int[] diameter){
        if(root==null)return 0;
        int lh = helper(root.left,diameter);
        int rh = helper(root.right,diameter);
        diameter[0] = Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}

/**
Explanation:
 


 */
