// Question_Name - The Painter's Partition Problem-II
// Problem_Link -  https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
// Platform - GeeksForGeeks



class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int i= 0;i<arr.length;i++){
            low = Math.min(arr[i],low);
            high+=arr[i];
        }
        
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(arr,mid,k)){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean isPossible(int[] arr , int min_time , int k ){
        
        int total_time = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>min_time)return false;
            total_time+=arr[i];
            if(total_time>min_time){
                k--;
                total_time = arr[i];
            }
        }
        if(total_time>0)k--;
        return k>=0;
    }
}

