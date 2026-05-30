// Question_Name - Fruit into basket
// Problem_Link -  https://leetcode.com/problems/fruit-into-baskets/
// Platform - LeetCode

class Solution {
    public int totalFruit(int[] fruits) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int ans = 0;
        for(int j = 0;j<fruits.length;j++){
            if(map.containsKey(fruits[j])){
                map.put(fruits[j],map.get(fruits[j])+1);
            }
            else map.put(fruits[j],1);
            
            while(map.size() > 2){
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

/**
Explanation:
Approach 1 : (Sliding Window + HashMap)

1.Try to maintain a window where the unique elements are exactly 2.
2.Map the element and its frequency in the HashMap.
3.Whenever the size of hashMap more than the 2 then shrink the window from the left.
4.Track the length of valid window  int the ans variable.

Time_Complexity - O(N)
Space_Complexity - O(N) using hashMap.

Approach 2 : (Optimal without extra space)




 */ 