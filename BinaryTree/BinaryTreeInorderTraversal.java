// Question_Name  - Binary Tree Inorder Traversal
// Problem_Link -   https://leetcode.com/problems/binary-tree-inorder-traversal/
// PlatForm - LeetCode


package BinaryTree;

import java.util.ArrayList;
import java.util.List;




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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                res.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode pre = predecessor(curr);
                if(pre.right==null){
                    pre.right=curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
    private TreeNode predecessor(TreeNode root){

        if(root.left == null)return root;
        TreeNode temp = root.left;
        while(temp.right!=null && temp.right!=root){
            temp=temp.right;
        }
        return temp;
    }
}

/**
Explanation
We have multiple solution for this question like inorder  traversal using recursion and iterative traversal using stack but they takes O(N) extra space complexity.
So, the morris traversal is the way or algorithm which can help to minimize the time from O(N) to O(1)

Intuition
1.for every node find its predecessor ( predecessor is the rightMost node of root.left substree)
2. link the predecessor with the curr root node so that we can move back because in tree only downward movement is possible so we are creating link so that we can make an upward movement.
3. see the code for clarification.

Time Complexity - O(N)
Space Complexity - O(1)

 */ 