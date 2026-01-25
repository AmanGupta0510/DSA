

// Question_Name - Minimum Window Substring
// Problem_Link  -  https://leetcode.com/problems/minimum-window-substring/
// PlatForm - LeetCode

package SlidingWindow;
import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
       
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.containsKey(ch))map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
        } // count the frequency of each character in t. 

        int count  = 0;
        int ans = Integer.MAX_VALUE;
        int sI = -1;
        int eI = -1;
        int i = 0;
        char[] str = s.toCharArray(); // convert the s into character array[].

        for(int j = 0;j<str.length;j++){
           
            if(map.containsKey(str[j])){
                int freq = map.get(str[j]);
                if(freq>0)count+=1;
                map.put(str[j],freq-1);
            }
            else map.put(str[j],-1);
            while(count==t.length()){ // shrink the window while count == t.length().
                if(ans>=j-i+1){
                    ans = j-i+1;
                    sI = i;
                    eI = j;
                }
                int freq = map.get(str[i]);
                freq++;
                if(freq>0)count--; 
                map.put(str[i],freq);
                i++;
            }
        }
        if(sI==-1)return "";
        sI = Math.max(0, Math.min(sI, str.length));
        eI = Math.max(sI, Math.min(eI+1, str.length));
        int count2 = eI - sI;
        return new String(str, sI, count2);
    }
}
/*
Explanation:-
Approach 1 (Sliding Window): 

Since the question is about minimum substring so, my first intuition is to use sliding window to take out the smallest possible substring.
First of all track the frequencies of t and then start traversing the string array s 
and when we found all the occurence of t in s then we consider it as a possible substring but we want the minimum so for that we start shrinking our window from left to right while maintaining the freq count and record the minimum substring which contains all occurrence of t.

Time_Complexity - O(m+n)
Space_Complexity - O(m+n)
 */ 
