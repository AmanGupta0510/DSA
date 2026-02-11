// Question_Name - Bottom View of Binary Tree
// Problem_Link -  https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// PlatForm - GeeksForGeeks
package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}



    private class Pair{
        int col ;
        Node root;
        public Pair(int col,Node root){
            this.col = col;
            this.root = root;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        TreeMap<Integer,Node> map = new TreeMap<>();
        
        // level-order-traversal
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair p = q.poll();
                map.put(p.col,p.root);
                if(p.root.left!=null)q.add(new Pair(p.col-1,p.root.left));
                if(p.root.right!=null)q.add(new Pair(p.col+1,p.root.right));
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Node> m:map.entrySet()){
            res.add(m.getValue().data);
        }
        return res;
        
    }
}

/*
Explanation :
Approach 1 (Level-Order-Traversal):
In this question we need to find all the nodes visible when the tree is viewed form the bottom.
and in the question it is stated that If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered
So,
1.Do a level Order traversal
2.for each node track its vertical col and store (col:Node) as key value pair in the treeNode so that we get the view in correct order.

         1(0)
        /\
(-1)   2 3 (1)

if we go left from root ,col = col-1.
if we go right from root ,col = col+1.
3.Why (col:Node) becoz if we have multiple Node with the same col then we need to return the latter Node so there is no sense to make list and return the last element we can use 
  map instead becoz if col is already there in the map then we sholud update the value with the current one and add if not present.

4.After done with the bfs , traverse the map and store all the value into the res and return it .

Time_Complexity - O(N)
Space_Complexity - O(w)

  
  
  


*/

