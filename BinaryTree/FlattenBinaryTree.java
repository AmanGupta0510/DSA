// Question Name - Flatten Binary Tree
// Problem_link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Platform - LeetCode


package BinaryTree;



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
    public void flatten(TreeNode root) {
    //    helper(root);
       TreeNode curr = root;
       while(curr!=null){
        if(curr.left!=null){
            TreeNode x = curr.left;
            while(x.right!=null){
                x = x.right;
            }
            x.right = curr.right;
            curr.right = curr.left;
            curr.left = null; 
        }
        curr=curr.right;
       }
    }
    private void helper(TreeNode root){

        if(root==null)return ;
        if(root.left == null && root.right==null)return ;

        helper(root.left);
        helper(root.right);
        TreeNode x = root.left;
        while(x!=null && x.right!=null){
            x = x.right;
        }
        if(x!=null){
            TreeNode y = root.right;
            x.right = y;
            root.right = root.left;
            root.left = null; 
        } 
    
    }
}

/**
Explanation:
Approach 1 :
PostOrder traversal + link change.
Intuition:
1.start a post order traversal.
2.Return from the leaf node
3.Once both the recursive calls have been completed then,find the predecessor and link the predecessor.right node to curr.right node.
4.point null to the curr.left and now curr.right points to curr.left node.
5.Recursively do the same things for others node as well.

Time Complexity - O(N)
SPace Complexity - O(N) recustion stack space


Approach2:
The intuition is simple just to preserve the preorder Order as we go 
So we maintain a pointer curr while we going down
first we check if curr.left node if null or not if not null then we find the predecessor 
and points the predecessor.right to curr.right node
and now curr.right starts pointing to the left substree and we now points the curr.left to null.
In this way we points the left substree to the right while maintinag the order and then move  the curr to the right and repeat.

Time Complexity - O(N)
SPace Complexity - O(1) 


 */