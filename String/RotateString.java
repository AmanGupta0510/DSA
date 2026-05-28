// Question_name - Rotate String
// Problem_link -  https://leetcode.com/problems/rotate-string/
// Platform - Leetcode
package String;

public class RotateString {
    



    public boolean rotateString(String s, String goal) {
 
        if(s.length()!=goal.length())return false;

        int i = 0; 
        int j = 0;

        int[] lps = lpsArrayBuilder(goal);
        String text = s+s;

        while(i<text.length()){

            if(text.charAt(i) == goal.charAt(j)){
                j++;
                i++;
                if(j==goal.length())return true;
            } 

            else{
                if(j!=0)j = lps[j-1];
                else i++;
            }  
        }
        return false;

    }
    private int[] lpsArrayBuilder(String goal){

        int[] lps = new int[goal.length()];
        int j = 0;
        for(int i = 1;i<goal.length();i++){

            if(goal.charAt(j) == goal.charAt(i)){
                j++;
                lps[i] = j;
            }
            else{

                if(j!=0){
                    j = lps[j-1];
                }
                else lps[i] = 0;

            }
        }
        return lps;
    }
}

/**
Explanation:-
Approach 1
This can be easily solve using naive approach for that

1.Check every element of each string if there is a match.
2.If there is a mismatch then start the goal iteration from scratch. 
Time complexity for this approach is somewhere around O(m*n),where m is the length of s and n is goal.

Approach 2 (KMP Algo.):
1. find the lps of goal 
    to find lps we need to store the length of string whose preffix and suffix are eqaul 

    ex: ABA -> Preffix | suffix
           A->   ""        "" -> 0 match
           AB->  A         B  ->   ""
           ABA-> A,AB      A,BA -> 1 match of length 1
           so lps of ABA is [0,0,1]
code:
for(int i = 1;i<goal.length();i++){
    if(goal.charAt(j) == goal.charAt(i)){
        j++;
        lps[i] = j;
    }
    else{
        if(j!=0){
            j = lps[j-1];
        }
        else lps[i] = 0;

    }
}

2.After finding the lps we have to check both the string and if there is any mismatch happens
then slide the goal upto certain index or upto the common prefix.
and here lps array actually use.      







 */

