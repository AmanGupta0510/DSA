// Question_Name - Tree Boundary Traversal
// Problem_Link - https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
// PlatForm - GeeksForGeeks

package BinaryTree;

import java.util.ArrayList;

public class BoundaryTraversal {

    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        // left substree

        // Approahc is simple
        // find root left substree all boundary nodes.(just traverse root'left element)
        // find all leaf nodes
        // find root right substree all boundary nodes.(just traverse root'left element)
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {
            res.add(root.data);
            return res;
        }
        res.add(root.data);
        leftSubtreeBoundary(root.left, res);
        leafBoundaryT(root, res);
        rightSubtreeBoundary(root.right, res);
        return res;

    }

    void leftSubtreeBoundary(Node root, ArrayList<Integer> leftBoundary) {

        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            return;
        }
        leftBoundary.add(root.data);
        root = root.left == null ? root.right : root.left;
        leftSubtreeBoundary(root, leftBoundary);

    }

    void rightSubtreeBoundary(Node root, ArrayList<Integer> rightBoundary) {

        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            return;
        }

        Node temp = root.right == null ? root.left : root.right;
        rightSubtreeBoundary(temp, rightBoundary);
        rightBoundary.add(root.data);

    }

    void leafBoundaryT(Node root, ArrayList<Integer> leafBoundary) {

        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            leafBoundary.add(root.data);
            return;
        }
        leafBoundaryT(root.left, leafBoundary);
        leafBoundaryT(root.right, leafBoundary);
    }

}
