package  BinarySearchTree;
// Question_Name - Validate Binary Search Tree
// Problem_Link -  https://leetcode.com/problems/validate-binary-search-tree/
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
    Long[] prev = new Long[]{Long.MIN_VALUE};
    public boolean isValidBST(TreeNode root) {
        
       if(root==null)return true;
       boolean left = isValidBST(root.left);
       if(root.val<=prev[0])return false;
       else{ prev[0] = (long)root.val; }
       boolean right = isValidBST(root.right); 

       return left&&right;
    }
}

/**
Explanation:
Approach 1 (inorder-traversal ):
Just do the inorder traversal and check whether the element aree in the increasing sequence or not by keeping tract of prev value.

Time_Complexity - O(N)
Space_Complexity - O(N), recursion stack space.


 */