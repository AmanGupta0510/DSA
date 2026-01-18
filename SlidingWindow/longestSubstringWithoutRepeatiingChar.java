// Question_Name - Longest Substring Without Repeating Characters
// Problem_link -  https://leetcode.com/problems/longest-substring-without-repeating-characters/
// PlatForm - LeetCode
package SlidingWindow;
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int ans = 0;
        for(int j = 0;j<s.length();j++){
            if(map.containsKey(s.charAt(j)))map.put(s.charAt(j),map.get(s.charAt(j))+1);
            else map.put(s.charAt(j),1);
            while(j-i+1 > map.size()){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0)map.remove(s.charAt(i));
                i++;
            }
            ans  = Math.max(ans,j-i+1);
        }
        return ans;
    }
}
/*
Explanation:-
Approach 1 (Naive):
The first Approach is to generate all possible substring and for each substring check whether the current
substring contains duplicates or not if not then gets it length and store it in ans and incase any other substring is of longest length then update the ans.

Time Complexity - O(n^2)
Space Complexity - O(1)

Approach 2 (Better):
The better approach is to maintain a window in which there are no duplicates present
all character inside the window is unique so, for maintaing that we need to use map which
helps to tell whether there are duplicates present in the current window
How! if size of curr window > map.size() then it confirmed that there are duplicates present
so,thereAfter we shrink the window and try to eliminate duplicates from the curr window.

Time Complexity - O(N)
space Complexity - O(N) as we use HashMap.

 */
