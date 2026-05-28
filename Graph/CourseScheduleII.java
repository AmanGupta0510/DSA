// Question_name  - Course Schedule II
// Problem_Link  -  https://leetcode.com/problems/course-schedule-ii/
// platform - LeetCode 


package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    



    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        // make a adjacencyList and calculate the indegree of each node.
        for(int i = 0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        
        // put all the node into the queue whose indegree is 0.
        for(int i = 0;i<indegree.length;i++){
            // System.out.print(indegree[i] + " ");
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int indx = 0;
        //Here,we pull out the node with zero indegree and decresese the count of indegree of its adjacent nodes.
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int node = q.poll();
                ans[indx++] = node;
                for(Integer i : adjList.get(node)){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        q.add(i);
                    }
                }
            }
        }
       
        if(numCourses != indx)return new int[]{};
        return ans;
  
    }
}
// Time_Complexity - O(N+E)
// Space_Complexity - O(N)
// jihugyuftydfghjiuyufty