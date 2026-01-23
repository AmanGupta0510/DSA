// Question_Name - Longest Substring with K Uniques
// Problem_Link  - https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// PlatForm - GeeksForGeeks

package SlidingWindow;
import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i = 0;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>(); 
        for(int j = 0;j<s.length();j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch))map.put(ch,map.get(ch)+1);
            else map.put(ch,1);
            
            while(map.size()>k){ // shrik the window when map.size()>k
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i),--freq);
                if(freq==0)map.remove(s.charAt(i));
                i++;
            }
            if(map.size()==k)ans = Math.max(ans,j-i+1);
            
        }
        return ans==0?-1:ans;
        
        
    }
}
/*
Explanation:-

Approach 1 (Sliding Window):
The approach is simple just track the frequency of each character
and when map.size() == k put the size in the ans after that expand the window and if at any 
point map size is beyond k then start shrinking the window from the left.

Time_Complexity - O(N)
Space_Complexity - O(N) as we use HashMap.




 */