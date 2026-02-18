// Question_Name - Count Complete Tree Nodes
// Problem_link  -  https://leetcode.com/problems/count-complete-tree-nodes/
// platForm - LeetCode  

package BinaryTree;
public class countNodeInCBT {



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

    public int countNodes(TreeNode root) {
        
        if(root==null)return 0;

        TreeNode left = root,right = root;
        int l = 1;
        int r = 1;
        while((left=left.left)!=null)l++;
        while((right=right.right)!=null)r++;
        if(l==r)return (1<<l)-1;
        return 1+countNodes(root.left)+countNodes(root.right);

    }
}
/**
Explanation:
Approach 1 :
1. Calculate LEFT height (go leftmost path) → O(logN)
2. Calculate RIGHT height (go rightmost path) → O(logN)  
3. If heights equal → Tree is PERFECT → Return 2^height - 1 ✓
4. Else → Recurse on children (one subtree likely complete)

Why efficient? Complete trees have structure → Often avoid full traversal!
"In complete binary trees, if leftmost= rightmost height, entire tree is full. Otherwise, at least one subtree will be full, giving us logN shortcut opportunities."

Time_Complexity - O(logn * logn)
Space_Complexity - O(h)






 */

