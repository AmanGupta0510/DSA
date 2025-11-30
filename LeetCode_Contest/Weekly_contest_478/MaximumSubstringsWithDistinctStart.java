// Question - Maximum Substrings With Distinct Start
// Problem Link - https://leetcode.com/problems/maximum-substrings-with-distinct-start/
// Platform - LeetCode

package LeetCode_Contest.Weekly_contest_478;
class Solution {
    public int maxDistinct(String s) {
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']>=1)continue;
            freq[s.charAt(i)-'a']++;
        }
        int count =0;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a'] == 1){
                freq[s.charAt(i)-'a']--;
                count++;
            }
        }
        return count;
    }
}

/*
Explanation :- 
Approach 1 - (Frequency Counting)

In this question we need to find the maximum number of substrings ,such that each substring starts with a distinct character no two substrings start with the same character.
So,the first point is to be note down is that each substrings start with a distinct character which means that the maximum no.of substring formed is the count of distinct character present in the string.
So,for this we can use the frequency array of size 26 to store the count of each distinct lowercase character present in the string.
After that we iterate over the frequency table and whenever we encounter a character with frequency 1 we increment our count variable and decrement the frequency count of that character by 1 to maintain the constraints of distinct starting character of substring.
Finally we return the count variable as our answer as the variable stores the possible maximum substrings with distinct starting character.

Time And Space Complexity:-
Time - O(n) as we iterate over the string atleast once.
space O(1) as we use a frequency array of fixed size 26. 



*/
