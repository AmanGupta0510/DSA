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
        // morris traversal binary tree threaded technique.

        // List<Integer> res = new ArrayList<>();
        // TreeNode curr = root;
        // while(curr!=null){

        //     if(curr.left==null){
        //         res.add(curr.val);
        //         curr=curr.right;
        //     }
        //     else{
        //         TreeNode pred = curr.left;
        //         while(pred.right!=null && pred.right!=curr){
        //             pred = pred.right;   
        //         }
        //         if(pred.right==null){
        //             pred.right = curr;
        //             curr = curr.left;
        //         }
        //         else{
        //             pred.right=null;
        //             res.add(curr.val);
        //             curr=curr.right;

        //         }
        //     }
        // }
        // return res;
   

    }
    private void helper(TreeNode root,List<Integer> res){
        if(root==null)return;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
}
}
