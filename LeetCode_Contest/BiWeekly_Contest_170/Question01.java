package LeetCode_Contest.BiWeekly_Contest_170;

class Solution {

    public int minimumFlips(int n) {

        String x = "";// for keeping binary representaion of n in string.
        String y = "";// for keeping reverse of binary representation of n in string.
        while(n>0){
            if((n&1)==1){
                x+='1';
                y = '1'+y;
            }
            else {
                x+='0';
                y = '0'+y;
            }
            n>>=1;
        }

        int count = 0;
        for(int i = 0;i<x.length();i++){
            if(x.charAt(i) != y.charAt(i))count+=1;
        }

        return count;
            
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 10;
        System.out.println(sol.minimumFlips(n));
    }

}

/*  
Explanation:
Given a positive integer n calculate the minimum number of flips required to make s equal to the reverse of its original form.

This can be solved by first converting the n in its binary representaion and stored that in a string x. Then in the same iteration we store its reverse in another string variable y.
Then we iterate over s and check whether every character of x is equal of y's character at same index or not if not then we simply count that and store the count in the count variable.

Finally we return the count variable as our answer.

Time And Space Complexity:
Time - O(log n) + O(s) , where s is the length of n binary representation.
Space - O(1) as we dont use kind of extra Space.


*/

