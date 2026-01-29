// Question_Name - Maximum Sum Combination
// Problem_Link  - https://www.geeksforgeeks.org/problems/maximum-sum-combination/1
// PlatForm - GeeksForGeeks

package PriorityQueues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i = a.length-1;
        int j = b.length-1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->y[0]-x[0]);
        HashSet<List<Integer>> visited = new HashSet<>();
        
        pq.offer(new int[]{a[i]+b[j] , i , j});
        
        ArrayList<Integer> ans = new ArrayList<>();
        visited.add(Arrays.asList(i,j));
        
        while(k-->0 && !pq.isEmpty()){
            
            int[] temp = pq.poll();
            ans.add(temp[0]);
            
            if(temp[1]-1 >= 0 && !visited.contains(Arrays.asList(temp[1]-1,temp[2]))){
                pq.offer(new int[]{a[temp[1]-1] + b[temp[2]] , temp[1]-1 , temp[2] });
                visited.add(Arrays.asList(temp[1]-1 , temp[2]));
            }
            if(temp[2]-1 >= 0 && !visited.contains(Arrays.asList(temp[1],temp[2]-1))){
                pq.offer(new int[]{a[temp[1]] + b[temp[2]-1] , temp[1] , temp[2]-1 });
                visited.add(Arrays.asList(temp[1] , temp[2]-1));
            }
        }
        
        return ans;
        
        
        
    }
}

/*
Explanation:

Approach 1 (Using Priority Queue):

1. Sort the both array
2. add the sum of last indices of both array into the priority queue and both indices int the set as List.
3. run a loop until k==0 and in that 3 scenarios occurs 1.-> a[i] + b[j] , 2-> a[i-1]+b[j]
   3-> a[i][j-1] add all these into the pq only if their indixes pair are unique.
   
   for ex: {9,2,3} -> {1,3} and {2,2} {9,3,2} -> {2,2} and {3,1} here there are duplicates occur and laterly this leads to a wrong answer.

Time_Complexity - O(nlogn)
Space_Complexity - O(n)


*/