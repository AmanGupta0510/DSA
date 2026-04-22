// Question Name - Capacity To Ship Packages Within D Days
// Problem Link -  https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// Platform - LeetCode


package BinarySearch;

public class CapacityToShipPackagesWithinDDays {
    



    public int shipWithinDays(int[] weights, int days) {
        
        int low = 1;
        int high = 0;
        for(int i = 0;i<weights.length;i++){
            high+=weights[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(weights,mid,days)){
                high=mid-1;
            }
            else{
                low = mid+1; 
            }
        }
        return low;
    }
    private boolean isPossible(int[] weights , int k , int days){


        int sum = 0;
        int count = 0;

        for(int  i = 0;i<weights.length;i++){
            if(weights[i]>k)return false;
            sum+=weights[i];
            if(sum>k){
                count++;
                sum  = weights[i];
            }

        } 
        return count+1 <= days;

    }
}

