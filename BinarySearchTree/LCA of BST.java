// Question Name - Lowest Common Ancestor of a Binary Search Tree
// Problem Link -  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// platform - Leetcode.
package BinarySearchTree;
//   Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    
    }
 

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)return null;
        if(p.val<root.val && q.val<root.val)return lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)return lowestCommonAncestor(root.right,p,q);
        else return root;

    }
}

// Explanation:
/*
Approach 1 (recursive movement based on p and q)
The intuition is simple 
1.if p and q both are less than root then LCA would be in the left subtree of the root.
2.if p and q both are greater than root then LCA would be in the right subtree of the root.
3.if neither condition above holds , then return root because p and q are on different side and root must be the LCS. 

Time_Complexity - O(N)
Space_Complexity - O(N) recursion stack space.



*/