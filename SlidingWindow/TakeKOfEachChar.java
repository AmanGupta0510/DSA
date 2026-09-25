package SlidingWindow;

public class TakeKOfEachChar {
    // Problem_Name - Take K of Each Character From Left and Right
// Problem_link - https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
// Platform - LeetCode


    public int takeCharacters(String s, int k) {

        // First calculate the frequesncy of each character
        int[] freq = new int[3];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        if(freq[0]<k || freq[1]<k || freq[2]<k)return -1;

        int i = 0;
        int ans = 0;
        for(int j = 0;j<s.length();j++){

            char ch = s.charAt(j);
            freq[ch-'a']--; // decrement the freq of jth character
            while(i<=j && freq[ch-'a'] < k){ // if the freq of the ch is less than k then shrink the window.
                freq[s.charAt(i) - 'a']++;
                i++;
            }
            ans = Math.max(ans , j-i+1); // the max window is our possible answer.
        }

        return s.length()-ans;

    }
}

