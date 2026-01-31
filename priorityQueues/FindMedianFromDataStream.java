// Question_Name - Find Median From Data Stream
// Problem_Link -  https://leetcode.com/problems/find-median-from-data-stream/
// PlatForm - LeetCode


package PriorityQueues;
import java.util.PriorityQueue;
class MedianFinder {
    
    PriorityQueue<Integer> pq1 ;
    PriorityQueue<Integer> pq2 ;
    int count;
    public MedianFinder() {
        this.pq1 = new PriorityQueue<>((a,b)->b-a);
        this.pq2 = new PriorityQueue<>();
        this.count = 0;
    }
    
    public void addNum(int num) {
        
        this.count+=1;
        int k = count/2;
        
        if(pq2.isEmpty() || pq2.peek()<num){
            pq2.offer(num);
        }
        else pq1.offer(num);

        if(!pq1.isEmpty() && pq2.size()<=(count-k))pq2.offer(pq1.poll());
        if(!pq2.isEmpty() && pq2.size()>(count-k))pq1.offer(pq2.poll());


    }
    
    public double findMedian() {
        
        if(count%2==0){
            return (pq1.peek()+pq2.peek())/2.0;
        }
        else return pq2.peek()*1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
Explanation:

Approach 1 (Using Priorit Queue):
The question is asking to find the median.
The idea is to store the elements in such a way that we can find median in O(1) time.
1. Create two heap a min and a max.
2. In a max heap we store first k element (k = TotalCount of element so far / 2).
3. In a min heap we store n-k element.
Ex:- lets say we have a list of [1,3,4,2,5], k = 5/2 = 2
     pq1->[2,1] and  pq2->[3,4,5]
     
4.How, we can make those two heaps???
  we make an arrangement such way that for odd length our median is in the peek() of pq2.
  so,by keeping this in mind.
  1.if pq2 is empty then straightly put the num into pq2.OR if pq2.peek()<num then also put the num into pq2 , so that pq2 maitain the min heap efficiently. 
  2.else if pq2.peek() >= num then put the num into pq1.
  3.now the time is for balancing both heap so,that both have k and n-k elements.
    if pq2.size<=n-k then insert into pq2 from pq1.
    if pq2.size>n-k or pq1.size<k then insert into pq1 from pq2.
    by doing such operations we make both heap balance and by making both heap balance we can easily get the median.

5.Now,to find the the median see if the totalCount of element so far is even or odd
  if even the take both heap peek() element and divide their sum by 2.
  if odd then directly return pq2.peek() becoz we balance our both heap in such a way that for odd length median is present in the second heap.

Time_Complexity - O(1)->findMedian and O(logn)->add
Space_Complexity - O(n) n is the number of element seen so far.  

 */  
