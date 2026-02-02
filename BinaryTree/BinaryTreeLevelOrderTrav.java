// Question_Name - Binary Tree Level Order Traversal
// Problem_Link  - https://leetcode.com/problems/binary-tree-level-order-traversal/
// PlatForm      -  LeetCode 
package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTrav {

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}

