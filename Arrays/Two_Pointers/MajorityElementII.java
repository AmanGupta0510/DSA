package Arrays.Two_Pointers;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int candidate1 = Integer.MAX_VALUE;
        int candidate2 = Integer.MAX_VALUE;
        int vote1 = 0;
        int vote2 = 0;

        for(int i = 0;i<nums.length;i++){
            if(candidate1==nums[i])vote1+=1;
            else if(candidate2 == nums[i])vote2++;
            else if(vote1 == 0){
                candidate1 = nums[i];
                vote1++;
            }
            else if(vote2 == 0){
                candidate2 = nums[i];
                vote2++;
            }
            else {
                vote1--;
                vote2--;
            }
            
        }  
        vote1 = 0;
        vote2  = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==candidate1)vote1++;
            else if(nums[i]==candidate2)vote2++;
        } 
        List<Integer> ans = new ArrayList<>();
        if(vote1>nums.length/3)ans.add(candidate1);
        if(vote2>nums.length/3)ans.add(candidate2);
        
        return ans;
    }
}
}
