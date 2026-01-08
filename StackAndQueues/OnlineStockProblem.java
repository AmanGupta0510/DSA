// Question_Name - Online Stock Span
// Problem_Link -  https://leetcode.com/problems/online-stock-span/
// PlatForm - LeetCode


package StackAndQueues;

import java.util.Stack;

public class OnlineStockProblem {
    
   


class StockSpanner {

   private  class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    } // here, i use Pair class to store the day and price of a stock.
   }
   
    Stack<Pair> st;
    Pair p;
    int day ;
    public StockSpanner() {
        st = new Stack<>();
        st.push(new Pair(-1,0));
        // st.push(p);
        day = 0; 
    }
    
    public int next(int price) {
       int count = 0;
    // System.out.println(st.size()+" "+st.peek());
       while(st.peek().x!=-1 && st.peek().y<=price)st.pop(); // popped out all day  when price of current day>=previous days,means we maintain monotonically decreasing stack from bottom to top.
       count  = day-st.peek().x;
       st.push(new Pair(day,price));
       day++;
       return count;
    }
}

// same concept use here as previous greater element + i add some indexing for the output.
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
