// Question_Name - Task Scheduler
// Problem_Link  - https://leetcode.com/problems/task-scheduler/
// PlatForm - LeetCode  

package PriorityQueues;


import java.util.*;
class Solution {
   
    public int leastInterval(char[] tasks, int n) {
      
        int[] freq = new int[26]; 

        for(int i = 0;i<tasks.length;i++)freq[tasks[i]-'A']++; // count the freq of each character of tasks.       
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        Queue<Integer> removedEle = new LinkedList<>();

        for(int i = 0;i<26;i++)if(freq[i]>0)pq.offer(freq[i]); // add the freq of each character into the max heap.
        
        int ans = 0;
        while(!pq.isEmpty()){
            int count  = -1;
            int x = n;
            while(x>=0){ // n-cycle
                if(pq.isEmpty())break;
                count+=1;
                int k = pq.poll()-1;
                if(k>0)removedEle.add(k); // putting the removed freq into the queue so that laterly we an add it to the max heap again. 
                x--;
            }
            if(!removedEle.isEmpty()){  
                count+=n-count;// here we coutn the idle time. 
                while(!removedEle.isEmpty())pq.offer(removedEle.poll()); // again adding back the fresh freq into the max heap 
            }
            ans+=count+1;
        }
        return ans;
    }
}

/**
Explanation:
Approach 1 (Using Prority Queue):

1. count the freq of each character int the freq array.

2. add all the freq>0 into the priority queue which maintains the max heap.

3. start with the max freq element , wait for n time interval and in between that count the less freq distinct element whicih can be fitted during the interval .

4. After counting the element calculate the idle time -> (count+= n-count) if in the case when number of other less freq tasks < interval time.  

5. adding back the all the  tasks used during the n-interval  with fresh freq.

6.  repeat until our priority queue is not empty.

Time_Complexity - O(Nlogn)
Space_Complexity - O(n)


Approach 2 (Greedy using maths formula):
when i will start greedy then find the solution using above mentioned strategy. 

 */
