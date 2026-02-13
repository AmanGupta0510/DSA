// Question_Name  -   Children Sum in a Binary Tree
// Problem_Link - https://www.geeksforgeeks.org/problems/children-sum-parent/1
// PlatForm - GeeksForGeeks

package BinaryTree;

public class ChildSumInABT {

    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public boolean isSumProperty(Node root) {
        // code here
        boolean[] valid = new boolean[] { true };
        int x = dfs(root, valid);
        return valid[0];
    }

    private int dfs(Node root, boolean[] valid) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;
        int left = dfs(root.left, valid);
        int right = dfs(root.right, valid);
        if (left + right != root.data) {
            valid[0] = false;

        }

        return root.data;
    }
}
/*
 * Explanation :
 * Appraoch 1 (DFS):
 * Approach is simple
 * 1. Do PostOrder traversal becoz PostOrder ensures that children compute first
 * before pareents checks.
 * 2.return from the leaf nodes
 * 3.if for any root if the sum of its left and right child's value is not == to
 * the curr root.data then set valid[0] = false to propagate failure up
 * 4.After the DFS traversal return valid[0].
 * 
 * Time_Complexity - O(N)
 * Space_Complexity - O(N) recursion stack space.
 */
