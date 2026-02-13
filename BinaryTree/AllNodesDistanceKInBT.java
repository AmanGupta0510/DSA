// Question_Name - All Nodes Distance K in Binary Tree
// Problem_Link -  https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// PlatForm - LeetCode

package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBT {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();
        if (k == 0) {
            res.add(target.val);

        } else
            dfs(root, target, k, res, 0);
        return res;
    }

    private int dfs(TreeNode root, TreeNode target, int k, List<Integer> res, int depth) {

        if (root == null)
            return -1;

        if (depth == k) {
            res.add(root.val);
            return 0;
        }
        int left, right;
        // downward
        if (root == target || depth > 0) {
            left = dfs(root.left, target, k, res, depth + 1);
            right = dfs(root.right, target, k, res, depth + 1);
        } else {
            left = dfs(root.left, target, k, res, depth);
            right = dfs(root.right, target, k, res, depth);
        }
        // upward
        if (root == target) {
            return 1;
        }
        if (left == k || right == k) {
            res.add(root.val);
            return 0;
        }
        if (left > 0) {
            dfs(root.right, target, k, res, left + 1);
            return left + 1;
        }

        if (right > 0) {
            dfs(root.left, target, k, res, right + 1);
            return right + 1;
        }
        return 0;

    }
}
