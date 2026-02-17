// Question_Name - Amout of Time For BinaryTree to be infected.
// Problem_link -  https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
// PlatForm  - LeetCode
package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class InfectedNode {
   

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

    public int amountOfTime(TreeNode root, int start) {
        if (root.left==null && root.right ==null)return 0;

        HashMap<TreeNode,TreeNode> childParentMapping = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode target = null;

        q.add(root);
        childParentMapping.put(root,null);
        while(!q.isEmpty()){
             
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();

                if(node.val == start)target = node;

                if( node.left!=null ){
                    childParentMapping.put(node.left,node);
                    q.add(node.left);
                }

                if( node.right!=null ){
                    childParentMapping.put(node.right,node);
                    q.add(node.right);
                }

            }

        }
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                TreeNode parent = childParentMapping.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
            }
            if(!q.isEmpty())count+=1;
        }
        return count;
    }
}

/*
Explanation:
Approach 1 (BFS): 
1.mapped parent of each node via level order traversing and find the infected node.

2.start a level order traversing from the infected node and add all its adjacent nodes (including parent into the queue). add unvisited nodes only to escape from redundant same node cycle.

3.for each non-empty level increment the count by one.

Time_Complexity - O(N)
Space_Complexity - O(N)



Note:- The point where i stuck:
       1.unable to figure out which traversal i need to do.
       2.the question is saying all its adjacent non-infected nodes , this gives a clear image of using tree in a graph way means bi-directional movement,node - to - child and node - to - parent.
       to achieve this first i make a map in which i store childNode with their respective parent. 
       3. if not taking track of infected node then the repeatition of nodes will occur so,it better to marked the visited node as infected.

*/

