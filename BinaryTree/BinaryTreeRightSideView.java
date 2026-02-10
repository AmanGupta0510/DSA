// Question_Name - Binary Tree Right Side View
// Problem_Link -  https://leetcode.com/problems/binary-tree-right-side-view/
// PlatForm - LeetCode

package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {



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

    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int i = 0;
            while(i<size){
                TreeNode node = q.poll();
                if(i==size-1)res.add(node.val);
                if(node.left!=null)q.add(node.left);
                if(node.right!=null)q.add(node.right);
                i++;
            }
        }
        return res;
    }
}
/**
Explanation:
Approach 1 (BFS / Level Order Traversing):
Question is simple they just want to know the right side of the tree
So, if we use BFS the rightmost node is at the last element of that level.
So, approach is simple:
1. Do a BFS
2. for each level fetch out the last element becoz that is at the rightmost part and that node is the first view form the right.    


Time_Complexity - O(N)
Space_Compleity - O(W) max width of tree.

 */

