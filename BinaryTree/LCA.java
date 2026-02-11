// Question_Name - Lowest Common Ancestor of a Binary Tree
// Problem_Link -  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// PlatForm - LeetCode


package BinaryTree;

public class LCA {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)return null;
        if(root.val == p.val || root.val == q.val)return root;

        TreeNode left =  lowestCommonAncestor(root.left,p,q);
        TreeNode right  = lowestCommonAncestor(root.right,p,q);
        if (left==null && right == null)return null;
        else if(left!=null && right != null)return root;
        return left==null?right:left;
    }
}
/**
Explanation :
Approach 1 (Dfs):

1.Do a dfs traversal .
2.if curr root.val is matching with either p or q then immediately return the curr root no need to check further.
3.Total 3 scenarios are arises :
  if no p and q are ther in the tree then in our left and right null is present so we return null.
  if we got p and q from left and right or vice versa then,the curr root is the lowest common ancestor bcz both have same parent.
  if either left or right have p or q then return not null variable.We assume that both p and q are in the same path.

Time_Complexity - O(N)
Space_Complexity - O(N) recursion stack space. 


 */
}
