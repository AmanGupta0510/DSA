package RecursionAndBacktracking;
// Question : Generate all binary strings of N bits
// Problem link : https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1
// Platform : GeeksforGeeks

import java.util.ArrayList;

class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        String bits = "";
        helper(n,res,bits);
        return res;
        
    }
    public void helper(int n,ArrayList<String> res,String bits){
        
        if(n==bits.length()){ // baseCase - when length of bits is equal to n then add it to the res.  
            res.add(bits);
            return;
        }
        // add '0'in bits and call helper function recursively
        helper(n,res,bits+'0');
        // add '1'in bits and call helper function recursively.
        helper(n,res,bits+'1');
    }
}