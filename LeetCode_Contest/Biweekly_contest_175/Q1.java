

// Question_Name -  Reverse Letters Then Special Characters in a String
// Problem_Link  -  https://leetcode.com/contest/biweekly-contest-175/problems/reverse-letters-then-special-characters-in-a-string/
// PlatForm - LeetCode

package LeetCode_Contest.Biweekly_contest_175;
import java.util.*;
class Solution {
    public String reverseByType(String s) {

        List<Character> ch = new ArrayList<>();
        List<Character> specialCh = new ArrayList<>();

        for(int i = 0;i<s.length();i++){
            char chr = s.charAt(i); 
            if(chr >='a' && chr<='z'){
                ch.add(chr);
            }
            else specialCh.add(chr);
        }
        String ans ="";
        int m = ch.size()-1;
        int n = specialCh.size()-1;
        for(int i = 0;i<s.length();i++){
            char chr = s.charAt(i);
            if(chr>='a' && chr<='z'){
                ans+=ch.get(m--);
            }
            else ans+=specialCh.get(n--);
        }
        return ans;

        
    }
}
