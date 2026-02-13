// Question_Name - Maximum Width Of Binary Tree
// Problem_Link -  https://leetcode.com/problems/maximum-width-of-binary-tree/
// PlatForm - LeetCode

package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfABinaryTree {

    // * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private class Pair {
        TreeNode root;
        int indx;

        public Pair(TreeNode root, int indx) {
            this.root = root;
            this.indx = indx;
        }
    }

    // public int widthOfBinaryTree(TreeNode root) {

    // Queue<Pair> q = new LinkedList<>();
    // int ans = 0;
    // q.add(new Pair(root,0));

    // while(!q.isEmpty()){

    // int size = q.size();
    // int min = Integer.MAX_VALUE;
    // int max = Integer.MIN_VALUE;
    // while(size-->0){
    // Pair p = q.poll();
    // int leftIndx = 2*p.indx+1;
    // int rightIndx = 2*p.indx+2;
    // min = Math.min(min,p.indx);
    // max = Math.max(max,p.indx);
    // if(p.root.left!=null)q.add(new Pair(p.root.left,leftIndx));
    // if(p.root.right!=null)q.add(new Pair(p.root.right,rightIndx));
    // }
    // ans = Math.max(ans,max-min+1);
    // }

    // return ans;
    // }

    int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 1, 0, list);
        return max;
    }

    private void dfs(TreeNode root, int indx, int depth, List<Integer> list) {
        if (root == null)
            return;
        if (list.size() == depth)
            list.add(indx);
        max = Math.max(max, indx - list.get(depth) + 1);
        dfs(root.left, indx * 2, depth + 1, list);
        dfs(root.right, indx * 2 + 1, depth + 1, list);
    }
}

/**
 * Explanation:
 * Approach 1 (BFS):
 * We can make a binary tree with the help of array also,So in this question we
 * are going to assign indexes to every node in the tree.
 * lets assume root index is 0 so its left and right children indexes are :
 * (2*i+1) and (2*i+2)
 * we assign indexes to every node in this way while doing a level order
 * traversal
 * for every level we keep track of min as well as max index
 * after every level we calculate the width = max-min+1 and return the maxWidth.
 * 
 * Time_Complexity - O(n)
 * Space_Complexity - O(W) max width of the tree.
 * 
 * 
 * Aprroach 2 (DFS):
 * In this the core idea is same only the way of implementation is chnged.
 * 1.We keep a list where we store only the index of left subtree leftMost
 * nodes.
 * 2.And then calculate the width -> current indx - the indx of leftMost nodes
 * of current depth + 1.
 * 3.Do the regular DFS .
 * 
 * Time_Complexity - O(N)
 * Space_Complexity - O(N) the recursion stack space.
 */
