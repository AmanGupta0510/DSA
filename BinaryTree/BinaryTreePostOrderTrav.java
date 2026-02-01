// Question_Name - Binary Tree Postorder Traversal
// Problem_Link  - https://leetcode.com/problems/binary-tree-postorder-traversal/
// PlatForm - LeetCode


package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTrav {
    

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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> res =  new ArrayList<>();
        helper(root , res);
        return res;
    }
    private void helper(TreeNode root , List<Integer> res){
        if(root==null)return;
        helper(root.left,res);
        helper(root.right,res);
        res.add(root.val);
    }
}
}
