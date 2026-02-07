// Question_Name - ZigZag Traversal
// Problem_Link  - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// PlatForm - LeetCode 


package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZawTraversal {


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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
        Queue<TreeNode> q = new LinkedList<>();

       
        List<List<Integer>> res = new ArrayList<>();
     
        if(root==null)return res;
        q.add(root); 
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            while(size-->0){
               TreeNode node = q.poll(); 
               if(count%2==0)temp.addLast(node.val); // since we want zigzaw that why for even height we add element normally but for the odd height we add in reverse order.
               else temp.addFirst(node.val);
               if(node.left!=null)q.add(node.left);
               if(node.right!=null)q.add(node.right);
            }
            count+=1;
            res.add(temp);
        }  
        return res;
    }
}
