// Problem_Name -  cheapest Flights Within K stops
// Problem_Link -  https://leetcode.com/problems/cheapest-flights-within-k-stops/
// Platform - LeetCode

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightWithKStops {




    class Pair{
        int node;
        int price;
        public Pair(int node , int price){
            this.node = node;
            this.price = price;
        }
    }
    class Triplet{
        int start;
        int node;
        int totlPrice;  
        Triplet(int start , int node , int totlPrice){
            this.start = start;
            this.node = node;
            this.totlPrice = totlPrice; 
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Queue<Triplet> q = new LinkedList<>();
        
        int[] distanceArray  = new int[n];
        for(int i = 0;i<distanceArray.length;i++){
            distanceArray[i] = Integer.MAX_VALUE;
        }

        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0;i<n;i++)adjList.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            adjList.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));     
        } 

        q.add(new Triplet(0,src,0));
        distanceArray[src] = 0;
        while(!q.isEmpty()){

            Triplet t = q.poll();
            if(t.start>k)continue;
            for(Pair i : adjList.get(t.node)){

                if(t.totlPrice+i.price < distanceArray[i.node] && t.start<=k){
                    distanceArray[i.node] = t.totlPrice+i.price;
                    q.add(new Triplet(t.start+1,i.node,distanceArray[i.node]));
                }

            }
        }

        if(distanceArray[dst] == Integer.MAX_VALUE)return -1;
        else return distanceArray[dst];
    }
}

/**
Standard Dijkstra finds the shortest path to all nodes, but doesn't track the number of stops. We need to modify it to:

Trrack stops as well as cost 
Don't stop when destination node found try all possible edges with K Stops.

Time_Complexity  - O(E) , E = number of edges
Space_Complexity - O(E)

 */

