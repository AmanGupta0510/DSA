// Question_Name - Longest subarray with Atmost two distinct integers
// Problem_Link -  https://www.geeksforgeeks.org/problems/fruit-into-baskets
// PlatForm - GeeksForGeeks

package SlidingWindow;
import java.util.HashMap;

class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        
        for(int j = 0;j<arr.length;j++){
            
            if(map.containsKey(arr[j])){
                map.put(arr[j],map.get(arr[j])+1);
            }
            else map.put(arr[j],1);
            
            while(map.size()>2){
                int freq = map.get(arr[i]);
                map.put(arr[i],freq-1);
                if(map.get(arr[i])==0)map.remove(arr[i]);
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
        
    }
}