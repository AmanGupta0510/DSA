// Question - Majority Element
// Problem Link - https://leetcode.com/problems/majority-element/

package Arrays.Two_Pointers;
class Solution {
    // public int majorityElement(int[] nums) {
    //     HashMap<Integer,Integer> map = new HashMap<>();

    //     for(int i = 0;i<nums.length;i++){
    //         if(map.containsKey(nums[i]))map.put(nums[i],map.get(nums[i])+1);
    //         else map.put(nums[i],1);
    //     }

    //     int max = -1;
    //     int ele = -1;

    //     for(Map.Entry<Integer,Integer> entry:map.entrySet()){
    //       if(entry.getValue() > max){
    //           ele = entry.getKey();
    //           max = entry.getValue();
    //       }
    //     }
        
    //     return ele;
    // }



    public int majorityElement(int[] nums) {
        
        int candidate = -1;
        int count = 0;
        for(int i = 0;i<nums.length;i++){

            if(count == 0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count+=1;
            }
            else{
                count-=1;
            }
        }
        return candidate;
    }
}
/*
Explanation :- 

The question is asking the  element that appears more than n/2 times.
Approach 1 (HashMap):-

The first solution comes to my mind is that use a hashmap to store the frequency of
each element and after that run a loop on the hashmap and find the max frequency element.

Time Complexity -> O(n)
Space Complexity -> O(n) as we use HashMap to store the frequency of each element.


Approach 2 (vote-Moore Algorithm) optimised :-
In this approach the intuition is simple just keep a count variable and a candidate variable 
which stores the majority element and increment count whenver element in the candidate is same as current element or decrement the count and so on...

As the majority element is one who appears more than n/2 times
So the candidate contains that element whose count is more than the others element after traversing the whole array.

Time Complexity -> O(n)
Space Complexity -> O(1) as we didn't use any extra space.

*/
