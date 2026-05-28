// Question_Name - Valid Anagram
// Problem_Link -  https://leetcode.com/problems/valid-anagram/
// Platform - Leetcode


package String;
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())return false;
        int count = 0;
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            count++;
        }

        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            if(freq[ch-'a']>0){
                freq[ch-'a']--;
                count--;
            }
        }

        return count==0;
    }
}

// Time Complextiy - O(m+n),m=s.length() and n = t.length()
// Space Complexity - O(26) ~ O(1)
    

