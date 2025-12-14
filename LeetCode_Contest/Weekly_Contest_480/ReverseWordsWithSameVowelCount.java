package LeetCode_Contest.Weekly_Contest_480;
import java.util.*;
class Solution {
    // public String reverseWords(String s) {

    //     List<String> str = new ArrayList<>();
    //     String st = "";
    //     int vowelC = 0;
    //     for(int i= 0;i<s.length();i++){
    //         if(s.charAt(i)!=' ')st+=s.charAt(i);
    //         else if(s.charAt(i)==' '){
    //             str.add(st);
    //             st="";
                
    //         }
    //     }
    //     if(st!="")str.add(st);
 
    //     for(int i = 0;i<1;i++){
    //         for(int j = 0;j<str.get(i).length();j++){
    //             if(str.get(i).charAt(j)=='a'||str.get(i).charAt(j)=='e'||str.get(i).charAt(j)=='i'||str.get(i).charAt(j)=='o'||str.get(i).charAt(j)=='u'){
    //                 vowelC+=1;
    //             }
    //         }
    //     }

    //     for(int i = 1;i<str.size();i++){
    //         int count = 0;
    //          for(int j = 0;j<str.get(i).length();j++){
    //             if(str.get(i).charAt(j)=='a'||str.get(i).charAt(j)=='e'||str.get(i).charAt(j)=='i'||str.get(i).charAt(j)=='o'||str.get(i).charAt(j)=='u'){
    //                 count+=1;
    //             }
    //         }
    //         if(count==vowelC){
    //             str.set(i,reverse(str.get(i)));
    //         }
    //     }
    //     String ans = "";
    //     for(int i =0;i<str.size();i++){
    //       if(i!=str.size()-1)ans+=str.get(i)+" ";
    //       else ans+=str.get(i);
    //     }
    //     return ans;
    // }
    // public String reverse(String s){
    //     String x = "";
    //     for(int i= 0;i<s.length();i++){
    //         x = s.charAt(i)+x;
    //     }
    //     return x;
    // }
       
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<StringBuilder> words = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        
        // Split words O(n)
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                current.append(s.charAt(i));
            } else {
                if (current.length() > 0) {
                    words.add(current);
                    current = new StringBuilder();
                }
            }
        }
        if (current.length() > 0) {
            words.add(current);
        }
        
        // Count vowels in first word O(first_word_length)
        int firstVowelCount = countVowels(words.get(0));
        
        // Process remaining words O(n)
        for (int i = 1; i < words.size(); i++) {
            int vowelCount = countVowels(words.get(i));
            if (vowelCount == firstVowelCount) {
                reverseInPlace(words.get(i));
            }
        }
        
        // Build result O(n)
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < words.size() - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
    
    private int countVowels(StringBuilder word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
    
    private void reverseInPlace(StringBuilder sb) {
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }
}

    
