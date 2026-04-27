// Question_Name - Course Schedule
// Problem_link -  https://leetcode.com/problems/course-schedule/
// Platform - Leetcode
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Convert the prerequisites into AdjList.
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i= 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        } 

        for(int i = 0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0;i<adjList.size();i++){
            for(Integer j : adjList.get(i)){
                indegree[j]++;
            }
        }
       
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int visit = 0;
        while(!q.isEmpty()){

            int node = q.poll();
            visit+=1;

            for(Integer i:adjList.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return visit==numCourses?true:false;


    }
}

/**
Explanation :

Approach 1 (TopoLogical sort):

We can solve this question using topological sort.

1.Convert the prerequisites into adjList (Directed graph).
2.Calculate the indegree of each vertex.
3.Add all those vertexes into the queue whose indegree is 0.To perform the topo sort using bfs.
4.Every time when we pop out a vertex from the queue increase the count of visit variable which keep track of vertexes numbering.
and also decrement the indegree of all the adjacent node of popped node because we no longer need that node. If any adjacent node’s in‑degree becomes 0, add it to the queue.
5.If the final count equals numCourses, then return true (all courses can be finished); otherwise, return false (there is a cycle).









 */