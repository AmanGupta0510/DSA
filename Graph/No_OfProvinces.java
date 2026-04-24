// Question Name - Number of Provinces.
// Problem_Link -  https://leetcode.com/problems/number-of-provinces/
// Platform - Leetcode

package Graph;
public class No_OfProvinces {

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count  = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count+=1;
                dfs(isConnected , i , visited);
            }
        } 
        return count;
    }
    private void dfs(int[][] arr , int node , boolean[] visited){

        visited[node] = true;
        for(int i = 0;i<arr.length;i++){
            if(arr[node][i] == 1 && !visited[i] ){
                dfs(arr , i , visited);
            }
        }
    }
}

/*
Explanation:
Approach 1: (Dfs)

The approach is simple we just have to  mark the connected node as visited for every non-visited node.

1.Declare a boolean array of size n (index represents the nodes 0->1th node and so on...).
2.For every non-visited array run a dfs for that particular node so, that all its connected whether directly or indirectly marks as visited.
3.Repeat for every non-visited node and keep a count tracker.

Time Complexity - O(n + E)
Space Complexity - O(n)





*/
    
