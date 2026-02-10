// Question_Name - Symmetric Tree
// Problem_Link -  https://leetcode.com/problems/symmetric-tree/
// PlatForm - LeetCode


package BinaryTree;

public class SymmetricTree {

    
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

        public boolean isSymmetric(TreeNode root) {
            if(root==null )return true;
            return helper(root.left,root.right);
        }
        private boolean helper(TreeNode p , TreeNode q){
            if(p==null && q==null)return true;
            if(p==null || q==null)return false;
            if(p.val!=q.val)return false;
            return helper(p.left,q.right) && helper(p.right,q.left); 
    
        }  
    }
    /**
    Explanation:
    Appraoch 1 (DFS):
    
    Just iterate in a symmetric way
    if root1 -> root1.left then root2 -> root.right.
    vice-versa
    
    Time_Complexity - O(N)
    Space_Complexity - O(N) recursion stack space.
    
    Approach 2 (BFS)
    This question can be easily solved using BFS but for that we need to first put all same level 
    node in a list after that we need to check that is the list is palindrome or not.
    But the point is that this lead to the increase in space as well as time Complexity.
    
    Time_Complexity - O(N).
    Space_Complexity - (W) W is the max Width in the tree.
    
    
    
    
    
     */

