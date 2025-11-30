package LeetCode_Contest.Weekly_contest_478;
import java.util.*;
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                List<Integer> temp = map.get(nums[i]);
                temp.add(i);

            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i],temp);
            }
        }
        int ans = Integer.MAX_VALUE; 
        for(int i = 0;i<nums.length;i++){
            int reverseNum = reverse(nums[i]);
            if(map.containsKey(reverseNum)){
                List<Integer> temp = map.get(reverseNum);
                int low = 0;
                int high = temp.size()-1;
                while(low<high){
                    int mid = (low+high)/2;
                    if(temp.get(mid)<=i)low = mid+1;
                    else high = mid;
                } 
                if(temp.get(high) > i)ans = Math.min(Math.abs(i-temp.get(high)),ans);

            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int reverse(int n){
        int x = 0;
        while(n!=0){
         x = x*10+(n%10);
         n/=10;

        }
        return x;
    }
}

/*
Explanation :-
Approach 1 - Using HashMap And Binary Search.
In this question we need to find the minimum absolute distance between mirror pairs present in the array.
So,first we create a HashMap to store the number and its corresponing indices so that we can easily access the indices of any number which is the mirror of a current number.
After that we iterate over the array and for each number we first find its mirror by passing the number to the method named reverse which reverse the current number
and after that we check if the mirror number is present in the hashmap or not if yes then we get the list of indices where that mirror number is present in the array.
then we apply the binary search on that list to find the minimum index which is greater than the current index.

Finally we calculate the minimum absolute distance and update our ans variable.

Time And Space Complexity:-
Time - O(n log m ), where n is the length of the input rray and m is the length of the list of indices.
Space - O(n) as we use Hashmap to store the number and its indices in the list. 








*/
