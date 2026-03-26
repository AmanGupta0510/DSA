// Question_Name - Insert into a Binary Search Tree
// Problem_Link  -  https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Platform - Leetcode

package BinarySearchTree;

public class InsertANodeInBST {
    




 
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<=val){
            root.right = insertIntoBST(root.right,val);
            return root;
        }
        else{
            root.left = insertIntoBST(root.left,val);
            return root; 
        }

    }
}
}
