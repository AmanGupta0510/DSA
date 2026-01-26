// Question_Name - Minimum Window Subsequences
// Problem_Link  - https://www.geeksforgeeks.org/problems/minimum-window-subsequence/1
// PlatForm      - GeeksForGeeks 

package SlidingWindow;
import java.util.*;

class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0;i<s2.length();i++){
            if(map.containsKey(s2.charAt(i)))map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
            else map.put(s2.charAt(i),1);
        }
        
        int i = 0;
        
        int minSize = Integer.MAX_VALUE;
        int sI = -1;
        int eI = -1;
        int count = 0;
        
        char[] ch = s1.toCharArray();
        
        for(int j = 0;j<ch.length;j++){
            
            if(map.containsKey(ch[j])){
                int freq = map.get(ch[j]);
                if(freq>0)count++;
                map.put(ch[j],freq-1);
            }
            else map.put(ch[j],-1);
            
            while(count==s2.length()){ 
                
                if(checkInSequence(s1,i,j,s2)){ //if our possible answer is in sequence then start shrinking the window from left. 
                    if(minSize>j-i+1){
                        minSize = j-i+1;
                        sI = i;
                        eI = j;
                    }
                    int freq = map.get(ch[i]);
                    freq++;
                    if(freq>0) count--;
                    map.put(ch[i],freq);
                    i++;
                }
                else break;
                
           }
            
            
            
        }
        
        if(sI==-1)return "";
        sI = Math.max(0,Math.min(sI,s1.length()));
        eI = Math.max(sI,Math.min(eI+1,s1.length()));
        int count2 = eI-sI;
        
        return new String(ch,sI,count2);
        
    }
    private boolean checkInSequence(String s,int sI,int eI,String t){
        int k = 0;
       
        for(int i = sI;i<=eI;i++){
            if(k<t.length() && s.charAt(i) == t.charAt(k)){
               
                k++;
            }
        }
        return k == t.length();
    }
}
