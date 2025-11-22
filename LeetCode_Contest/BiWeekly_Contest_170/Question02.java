// Question - Total Waviness of Numbers in Range I
// Problem Link - https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/
// Platform - LeetCode

package LeetCode_Contest.BiWeekly_Contest_170;

class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;
        for(int i = num1;i<=num2;i++){
            String str = String.valueOf(i);
            int count = 0;
            for(int j = 1;j<str.length()-1;j++){
                int x = str.charAt(j-1)-'0';
                int y = str.charAt(j)-'0';
                int z = str.charAt(j+1)-'0';
                if((y>x && y>z) || (y<x && y<z))count+=1;
            }
            waviness+=count;   
        }
        return waviness;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 10;
        int num2 = 12;
        System.out.println(sol.totalWaviness(num1, num2));
    }
}

/*
Actually the question is preetty much straight forward and simple to understand.
We have to find total Waviness of numbers in given range[num1 to num2].


The waviness of a number is defined as the total count of its peaks and valleys:
1. A digit is a peak if it is strictly greater than both of its immediate neighbors.
2. A digit is a valley if it is strictly less than both of its immediate neighbors.
3. The first and last digits of a number cannot be peaks or valleys. 

So, the simple and intuitive approach to solve this is to iterate over the given range and convert each number into a string
and after that iterate over the  digit string and count the peaks and valleys 
after that add the count to the waviness variable.

Time And Space Complexity:
Time - O(n*k),where k is the average number of digits in the numbers from num1 to num2.
Space - O(1) as we dont use kind of extra Space.

*/
