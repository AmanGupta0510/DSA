
// Question_Name - Serialize and Deserialize Binary Tree
// Problem_Link -  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Platform - LeetCode


package BinaryTree;
import java.util.LinkedList;
import java.util.Queue;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
  
    public String serialize(TreeNode root) {
        if(root==null)return "null" ; 
        String path = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.poll();
                if(node==null){
                    path = path+"null"+" ";
                }
                else{
                    path = path+node.val+" ";
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
      
      
        return path;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        if(s[0].equals("null"))return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        for(int i = 0;i<s.length;i++){
            if(q.isEmpty())break;
            int leftIndx = 2*i+1;
            int rightIndx = 2*i+2;
            TreeNode node = q.poll();  
            if(leftIndx<s.length && !s[leftIndx].equals("null")){
                node.left = new TreeNode(Integer.parseInt(s[leftIndx]));
                q.add(node.left);
            }
            if(rightIndx<s.length && !s[rightIndx].equals("null")){
                node.right = new TreeNode(Integer.parseInt(s[rightIndx]));
                q.add(node.right);
            }

          
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

