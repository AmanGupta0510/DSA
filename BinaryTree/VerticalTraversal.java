// Question_Name - Vertical Order Traversal of a Binary Tree
// Problem_Link -  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// PlatForm - LeetCode
package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalTraversal {

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

    private class Pair{
        TreeNode node;
        int col;
        int h;
        public Pair(TreeNode node,int col,int h){
            this.node = node;
            this.col = col;
            this.h = h;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            // priority -> col>height>nod.val.
            if (a.col != b.col) {
                return a.col - b.col;  // Primary: compare col 
            }
            if(a.h!=b.h){             // secondary: compare height
                return a.h-b.h;
            }
            else return a.node.val-b.node.val; // third: compare node.val
        });


        helper(root,0,0,pq);

        List<List<Integer>> res = new ArrayList<>();

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            Pair p  = pq.poll();
            while(!pq.isEmpty() && p.col == pq.peek().col){
                temp.add(p.node.val);
                p = pq.poll();
            }
            temp.add(p.node.val);
            res.add(temp);
        }
        return res;
    }
    private void helper(TreeNode root,int col,int h,PriorityQueue<Pair> pq){
        if(root==null)return;
        pq.offer(new Pair(root,col,h));
        helper(root.left,col-1,h+1,pq);
        helper(root.right,col+1,h+1,pq);
    }
}
/**
Explanation :

Aprroach 1:
We have to do a vertical order traversal.
vertical traversal start form the leftmost node to rightmost node.
So, since it is given in the question that root of the tree is (0,0) row,col.
So,left children will be at positions(row+1,col-1)
and right children will be at positions(row+1,col+1).

So fo tracking the row as well as col we can do a preOrder traversal
so that we can correctly put the right index of col and row for every node.
and return node in a sorted order with respect to column for this we'll use min heap.

Edges cases :
Priority shift from col to row if 2 or more have same col index
and in a same way priority shift from row to node.val if 2 or more have same row index.

Time_Complexity - O(nlogn) n for preorder traversal and log n for offer and poll operation in minHeap.
Space_Complexity - O(n)

 */ 

