// Question_Name - Root To Leaf Path
// Problem_Link - https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
// PlatForm - GeeksForGeeks


package BinaryTree;

import java.util.ArrayList;

public class RootToLeafPath {
    

// Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}


    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        preorder(root,res,temp);
        return res;
        
    }
    private static void preorder(Node root,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> temp){
        if(root==null)return;// if root == null means root is not a leaf node.
        
        temp.add(root.data); // add curr root.data into temp.
        
        if(root.left==null&&root.right==null){ // if root's left and right both are null then root is leaf so, add it in the res .
            res.add(new ArrayList<>(temp));
        }
        preorder(root.left,res,temp); // left subtree
        preorder(root.right,res,temp); // right subtree
        temp.remove(temp.size()-1);    // when both calls completed remove the curr node from the temp.and then return.  
    }
}

// Time_Complexity - O(N)
// Space_Complexity - O(N)_

