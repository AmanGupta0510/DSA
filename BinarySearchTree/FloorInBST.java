// Question_Name - Floor in BST 
// Problem_Link - https://www.geeksforgeeks.org/problems/floor-in-bst/1
// Platform - GeeksForGeeks
package BinarySearchTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}


class Solution {
    int ans = -1;
    public int findFloor(Node root, int x) {
        // code here
        return helper(root,x);
  
    }
    private int helper(Node root,int x){
       
        if(root==null)return -1;
        if(root.data == x)return x;
        if(root.data <= x){
            int ans = helper(root.right,x);
            return ans == -1 && root.data<=x ? root.data : ans;
        }
        else if(root.data > x){
            int ans = helper(root.left,x);
            
            return ans == -1 && root.data<=x ? root.data : ans;
        }
        else return -1;
        
       
    }
    
}