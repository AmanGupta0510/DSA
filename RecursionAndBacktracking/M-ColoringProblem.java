/*
Question_Name - M-Coloring Problem
Problem_Link - https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
PlatForm - GeeksForGeeks
*/

package RecursionAndBacktracking;
import java.util.*;
class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[][] adj = new int[v][v];
        for(int[] edge : edges) {
           adj[edge[0]][edge[1]] = 1;
           adj[edge[1]][edge[0]] = 1;  // Undirected graph
        }
        
        int[] coloredVertex = new int[v];
        Arrays.fill(coloredVertex,-1);
        return helper(adj, m,coloredVertex, 0,v);
            
        
        
    }
    private boolean helper(int[][] edges,int m,int[] coloredVertex,int indx,int v){
        
        if(indx == v ){
            return true;
        }
       
        for(int i = 0;i<m;i++){
            if(valid(edges,i,indx,coloredVertex,v)){
                coloredVertex[indx] = i;
                if(helper(edges,m,coloredVertex,indx+1,v))return true;
                coloredVertex[indx] = -1;
            }
        }
        return false;
    }
    private boolean valid(int[][] edges,int color,int vertex,int[] coloredVertex,int v){
        
        for(int i = 0;i<v;i++){
           
                if(edges[vertex][i] == 1 || edges[i][vertex]==1){
                    if(coloredVertex[i]==color)return false;
                }
               
            
        }
        return true;
    }
    
}
/*
The First Appraoch Comes to my mind is to use all colors for each vertex.

For each vertex we take a decison whether current color is suitable or not through valid Function whcih check no adjacent vertex share same color
if it is valid then we put that particular color to current indx and recurse to next vertex ,for each vertex we will do it like this
if in case recursion return false then we backtract,remove color and try for next color.
if recursion return true then we assume that all vertex are colored according to constraint and we return true.

Time Complexity - O(v^m)
Space Complexity - O(v)
*/
