// Question_Name - Consecutive 1's not allowed
// Problem_Link - https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
// PlatForm - GFG

package RecursionAndBacktracking;

public class Consecutive1NotAllowed {
  

class Solution {
    int countStrings(int n) {
        // code here
       
        int[][] dp = new int[n+1][2];
        for(int i = 0;i<n+1;i++){
           dp[i][0] = -1;
           dp[i][1] = -1;
        }
        return helper(n,dp,0,0);
        
        
    }
    private int helper(int n , int[][] dp , int sI,int prev){

        if(sI>=n){
            
            return 1;
          
        }
        
        if(dp[sI][prev]!=-1){
            return dp[sI][prev];
        }
        int placeZero = helper(n,dp,sI+1,0);
        int placeOne = 0;
        if(prev==0){
            placeOne = helper(n,dp,sI+1,1); 
        }
        
        return dp[sI][prev] = placeZero+placeOne;
    }
}

/*
Explanation:
Approach 1 (Recursive):

The first solution is generate every possible string which does n't contains 
consecutive 1's.

Recursion Logic -> Run a recursive Function for 'O'. 
                but for one , first check whether the current string last character is not '1'
                if not then run this function also. 
                keep the count of both and atLast return the count;
                
Time_Complexity - O(2^N) (TLE)
Space_Complexity - O(N)
                
Approach 2 (Memoization):

The Optimal solution is to use memoization so that we don't have to calculate the valid string again and agian
ex:
string A - "000_ _"
string B - "100_ _"

so,here at the 3rd index we need to fill either 0,1.
But the  2nd index of both string have 0's so it means after that the string have 2 choice either 0,1 
and the total move for string A and  B are identical to make the string a valid one.

String A goes first: The recursion runs all the way down, finds out there are exactly X ways to finish the string, and saves it in our notebook: dp[3][0] = X.

String B comes next: When the recursion reaches index 3 for String B, it doesn't recalculate anything. I
t checks the notebook,sees dp[3][0] is already X, and instantly returns it!


Time_Complexity - O(N)
Space_Complexity - O(N)

*/
}
