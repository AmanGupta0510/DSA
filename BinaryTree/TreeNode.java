// Question_Name -  Binary Tree Preorder Traversal
// Problem_Link -   https://leetcode.com/problems/binary-tree-preorder-traversal/
// PlatForm  - LeetCode

package BinaryTree;
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    private void helper(TreeNode root,List<Integer> res){

        if(root==null)return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res); 
    }
}
/*
Explanation:
Appraoch 1 :
Since we need to find the preorder of the given tree
follow this pattern:
data -> recurse(left part of tree) -> recurse(right part of tree)

Time_Complexity - O(N)
Space_Complexity - O(N)  

*/