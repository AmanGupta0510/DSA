package BinaryTree;

import java.util.HashMap;

public class ConstructBTFromPreAndInorder {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preL, int preR, int inOL, int inOR,
            HashMap<Integer, Integer> map) {

        if (preL > preR || inOL > inOR)
            return null;
        int rootVal = preorder[preL];
        // int i = inOL;
        // for(;i<=inOR;i++){
        // if(inorder[i]==rootVal){
        // break;
        // }
        // }
        int i = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int inorderLsI = inOL;
        int inorderLeI = i - 1;
        int inorderRsI = i + 1;
        int inorderReI = inOR;

        int preorderLsI = preL + 1;
        int preorderLeI = (i - inorderLsI) + preL;
        int preorderRsI = preorderLeI + 1;
        int preorderReI = preR;

        root.left = helper(preorder, inorder, preorderLsI, preorderLeI, inorderLsI, inorderLeI, map);
        root.right = helper(preorder, inorder, preorderRsI, preorderReI, inorderRsI, inorderReI, map);
        return root;
    }

}

/**
 * Approach 1 Build Naively binary tree with the help of inoder and preorder
 * tree property :
 * 
 * Steps :
 * 
 * 1.In preorder the root appears first so take out the root and search it on
 * inorder array to get the left substree and right subtree of the root
 * efficiently.
 * 
 * 2. declare a pointers which can keep track of left substree sI and eI and
 * vice versa for both preorder and inorder.
 * 
 * 3. recursively call the function to build left and right subtree of the root.
 * 
 * 
 * Time_Compleity - (N^2) int w.c, bcz we traverse whole loop twice especially
 * the inorder array first traversal is for recursion thats ok but the second
 * traversal is redundant for finding the root element in the inorder array.
 * Space_Complexity - O(N)
 * 
 * Approach 2 :
 * 
 * Same intuition and approach but instead for traversing whole array again
 * angain for finding the root element we can put the inorder elements into the
 * hahsmap so the retrival part become O(1).
 * 
 * Now,TIme_Complexity - O(N)
 * 
 * 
 * 
 * 
 * 
 */
