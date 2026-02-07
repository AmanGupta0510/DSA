// Question_Name - Binary Tree Maximum Path Sum
// Problem_Link -  https://leetcode.com/problems/binary-tree-maximum-path-sum/
// PlatForm - LeetCode


package BinaryTree;

public class BinaryTreeMaximumPathSum {

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

    public int maxPathSum(TreeNode root) {
       
        int[] pathSum = new int[]{Integer.MIN_VALUE};
        helper(root,pathSum);
        return pathSum[0];

    }
    // private void maxPathSumHelper(TreeNode root,int[] pathSum){
    //     if(root==null)return;
    //     int leftSum = helper(root.left);
    //     int rightSum = helper(root.right);
    //     System.out.println(leftSum+" "+rightSum);
    //     if(leftSum <0)leftSum=0;
    //     if(rightSum<0)rightSum=0;
    //     pathSum[0] = Math.max(pathSum[0],leftSum+rightSum+root.val);
    //     maxPathSumHelper(root.left,pathSum);
    //     maxPathSumHelper(root.right,pathSum);
         
        
    // } 
    private int helper(TreeNode root,int[] pathSum){

        if(root==null)return 0;

        int leftSum = helper(root.left,pathSum);
        int rightSum = helper(root.right,pathSum);
        if(leftSum<0)leftSum=0;
        if(rightSum<0)rightSum=0;
        pathSum[0] = Math.max(pathSum[0],leftSum+rightSum+root.val);
        return Math.max(leftSum,rightSum)+root.val;

       
    }
}

/**
Explanation:

Approach 1 (Simple Approach):

In this question a binary tree is given and i need to find the Max path Sum of a path.
Path - in a binary tree it is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connection them.
ex:   5
     / \
    4   8
   /   / \
 11   13  4
 / \   /
7   2 1
7->11->4->5->8->13 = 48 is a  path becoz all nodes are adjacent and connected in a sequence.
7 -> 11 -> 2 -> 4  this is not a path becoz 7->11->2 this doesn't match the path definition 7 -> 11 -> 2 is like diversion no sequence path.

So, the first approch comes to my mind 
1. for every node calculate its left sub-tree max sum ex; include root with the left sum or right sum.
   and do same for right sub-tree.
2. and for that node add its value with its left-subtree max sum and right subtree max sum
   and keep that in a variable where u keep track if for other nodes of the sum is greater > current     then update that and so onn...
3. do the above steps again and again,basically check for every node present in the tree.  

Time_Complexity - O(n^2) in the worst case.
Space_Complexity - O(n) recursion stack space. 


Approach 2 (better than normal):

If we examine our previous approach then we get to know that for the same node we do repeated task 
which is kind of redundant steps.
becoz while we calculating the path sum for the root we traverse to whole tree
and again we do this for rest nodes.

Approach to minimize these redundatns steps.
1. Do postorder traversal.
2. return with the root.val + Max(leftSum,rightSum) becoz in prev approach we return with the max(leftSum,rightSum)+root.val bcz we want maximum so we check in which part the sum is max.    
3. after done with both left and right call store the sum(leftSum+rightSum+root.val) of curr root int the variable to keep track of max sum seen so far and later if greater sum we found then simply replace the prev with curr sum.

Time_Complexity-O(n)
Space_Complexity - O(n) recurson stack space.  

 */

