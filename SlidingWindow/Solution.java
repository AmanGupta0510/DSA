// Question_Name - Fruit Into Baskets
// Poblem_Link -   https://leetcode.com/problems/fruit-into-baskets/
// PlatForm - LeetCode
package SlidingWindow;
import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;  
        int ans  = 0; 
        for(int j=0;j<fruits.length;j++){
           if(map.containsKey(fruits[j]))map.put(fruits[j],map.get(fruits[j])+1);
           else map.put(fruits[j],1);
            if(map.size()>2){ // shrink the window when the fruits count > 2.
                int freq = map.get(fruits[i]);
                if(--freq == 0)map.remove(fruits[i]);
                else map.put(fruits[i],freq);
                i++;
            }
            ans = Math.max(ans,j-i+1);
        } 
        return ans;
    }
}
