//Question_Name -  Number of Substrings Containing All Three Characters
// Problem_Link -  https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// PlatForm - LeetCode

package SlidingWindow;

class Solution{ 

    public int numberOfSubstrings(String s) {
     
        int a = -1;
        int b = -1;
        int c = -1;
        int ans = 0;
        for(int i = 0 ;i<s.length();i++){
            char ch = s.charAt(i);
            switch(ch){
            case 'a':
                a = i;
                break;
            case 'b':
                b = i; 
                break;
            case 'c':
                c = i;
                break;  
            }
            if(a!=-1 && b!=-1 && c!=-1){
                ans+= Math.min(a,Math.min(b,c))+1;
            }       
        }
        return ans;
    }
}




/**
Explanation:
Appraoch 1 (SLididng Window):
While traversing the string for every index keep track the 1st occurrence of a/b/c.
by keeping track of all character 1st occurence indices helps to maintain a window with exactly 3 distinct occurrence of a,b,c.
lets say i m on the jth index and ,and i found all char are occurrs till jth index , then find the min indexes among them(a,b,c 1st index) then we can say that for the jth index  from 0 to minIndex we can make a valid substring ending at jth and so for that we return minIndex+1 as the number of substring we can make.

Time_Complexity - O(N)
Space_Complexity - O(1)






 */ 
