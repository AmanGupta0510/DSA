package StackAndQueues;

public class TheCelebrityProblem {
    
    class Solution {
    public int celebrity(int mat[][]) {
        // code here
        // Brute Force
        // int[] incomingEdge = new int[mat.length];
        // int[] outgoingEdge = new int[mat.length];
        // for(int i = 0;i<mat.length;i++){
        //     for(int j = 0;j<mat[i].length;j++){
        //         if(i!=j && (mat[j][i] == 1 || mat[i][j] == 1)) {
        //           if(mat[j][i] == 1) incomingEdge[i]++; 
        //             if(mat[i][j] == 1) outgoingEdge[i]++;
        //         }
                
        //     }
        // }
        // for(int i = 0;i<incomingEdge.length;i++){
        //     if(incomingEdge[i]==mat.length-1 && outgoingEdge[i]==0)return i;
        // }
        // return -1;

        
        // Optimal
        int celebrity = 0;
        for(int i = 1;i<mat.length;i++){
            if(mat[celebrity][i] == 1){
                celebrity = i;
            }
        }
        for(int i = 0;i<mat.length;i++){
            if(i!=celebrity && (mat[celebrity][i] == 1 || mat[i][celebrity]==0))return -1;
        }
        
        return celebrity;
        
    }
}
/*
Explanation:
Appraoch 1 (Brute-Force):
The first appraoch is to calculate the indegree and outdegree of each element and after that
find such element whose idegree = mat.length-1 and outdegree = 0,it means that element known by every n-1 element but he doesn't anyone

Time Complexity - O(N^2) as we traverse whole matrix.
Space Complexity - O(N) as we use two array to store indegree and outdegree of each element.

Approach 2 (Optimal):
The optimal way is to find such element who can be our celeberity
ex:A->B,A knows B so A can't be our answer so shift to B as our possible answer and so on...

after traversing the array and finding the possible element check if that element is known by everyOne but that element doesn't know anyone
how can we check 
simply by checking if that elemment don't outgoing edge and have incoming edge from every other element.

Time Comolexity - O(N)
Space Complexity - O(1)




*/
}
