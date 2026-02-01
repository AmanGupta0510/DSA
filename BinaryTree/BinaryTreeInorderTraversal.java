package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    
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

// Question_Name  - Binary Tree Inorder Traversal
// Problem_Link -   https://leetcode.com/problems/binary-tree-inorder-traversal/
// PlatForm - LeetCode
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;

    }
    private void helper(TreeNode root,List<Integer> res){
        if(root==null)return;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
}
}
