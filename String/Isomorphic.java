// Question - Isomorphic Strings
// Problem_Link - https://leetcode.com/problems/isomorphic-strings/
// Platform - LeetCode

package String;

import java.util.HashMap;

public class Isomorphic {


    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();

        for(int i = 0;i<s.length();i++){

            if(map1.containsKey(s.charAt(i)) ){
                char ch1 = map1.get(s.charAt(i));
                if(ch1!=t.charAt(i))return false;
                
            }
            else if(map2.containsKey(t.charAt(i))){
                char ch2 = map2.get(t.charAt(i));
                if(ch2!=s.charAt(i))return false;
            }
            else{
                map1.put(s.charAt(i),t.charAt(i));
                map2.put(t.charAt(i),s.charAt(i));

            }
        }
        return true;
    }
}

