// Question_Name - Construct Binary Tree from Inorder and Postorder Traversal
// Problem_Link  - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Platform - LeetCode

package BinaryTree;

import java.util.HashMap;

public class ConstructBTFromPostAndInorder {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postL, int postR, int inOL, int inOR,
            HashMap<Integer, Integer> map) {

        if (postL > postR || inOL > inOR)
            return null;

        int rootval = postorder[postR];

        int index = map.get(rootval);

        int inorderLsI = inOL;
        int inorderLeI = index - 1;
        int inorderRsI = index + 1;
        int inorderReI = inOR;

        int postOLsI = postL;
        int postOLeI = (index - inOL) + postOLsI - 1;
        int postORsI = postOLeI + 1;
        int postOReI = postR - 1;

        TreeNode root = new TreeNode(rootval);
        root.left = helper(inorder, postorder, postOLsI, postOLeI, inorderLsI, inorderLeI, map);
        root.right = helper(inorder, postorder, postORsI, postOReI, inorderRsI, inorderReI, map);
        return root;

    }
}

/**
 * Explantion:
 * APproach :
 * 
 * Same intuition and aprroach as in the inorder and preorder.
 * but instead of preorder here postorder so only indexing changes in pre order
 * our root at 0th index but post order root at the n-1th index.
 * 
 */
