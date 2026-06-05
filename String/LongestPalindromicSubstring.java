// Question_Name - Longest Palindromic Substring
// Problem_Link -  https://leetcode.com/problems/longest-palindromic-substring/
// Platform - LeetCode

package String;

public class LongestPalindromicSubstring {



    public String longestPalindrome(String s) {
        
        // i don't know the approach as well as intuition so lets watch tutorial and all. 
        if(s.length()<=1)return s;
        int maxLen = 1;
        String ans = "";

        for(int i = 0;i<s.length()-1;i++){

            String evenPalindrome = expandFromCenter(s,i,i+1);
            String oddPalindrome = expandFromCenter(s,i,i); 

            if(oddPalindrome.length()>=maxLen){
                ans = oddPalindrome;
                maxLen = ans.length();
            }
            if(evenPalindrome.length() >= maxLen){
                ans = evenPalindrome;
                maxLen = ans.length();
            }
        }
        return ans;
    }
    private String expandFromCenter(String s , int l , int r){
        
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
          
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}

/**
Explanation:
Approach 1 (Naive):
Generate all possible substring and for each substring check whether that substring is palindrome or not.

Time_Complexity - O(N^3)
Space_Complexity - O(1)

Approach 2(Better);
Expand from the center
Here, the intuition is that for every index expand the pointers if the characters are equal and expand until we will get non-matching character.
Since Palindrome can be of two length either odd or even so for that for each index we will 
run the same function two times, evenLength Palindrome and another oddLength palindrome 

                          abba 
                           | 
    i = 0 then l = 0 and r = i+1 -> evenLength palindrome.
    i = 0 then l = 0 and r = 0 -> oddLength palindrome.

and we have to take both in consideration for our ans .

Time_Complexity - O(N^2)
Space_Complexity - O(1)


 */
