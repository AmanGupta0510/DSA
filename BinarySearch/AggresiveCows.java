class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        
        Arrays.sort(stalls);
       
        int low = 1;
        int high = stalls[stalls.length-1] - stalls[0];
        
        while(low<=high){
            int mid = (low+high)/2;
            if(helper(stalls,mid,k)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return high;  
        
    }
    private boolean helper(int[] stalls , int distance , int k){
        
            int stall = 0;
            
            for(int i = 0;i<stalls.length;i++){
                
                if(stalls[i] - stalls[stall] >= distance ){
                    k-=1;
                    stall = i;
                }
                
            }
            return k<=1;
    }
}

/*
Explanation :
Approach (Binary Search)

We do a binary search on the absolute position of stalls (max-min)
The question is saying about minimum distance between two stalls is max possible
so,it's something like All the poosible distance but we have to return the max one. so for that if lets say curr dist satisfy the condition then we move to the right.
And we sort the array so that we can easily find the distence between tow stalls.

1.Sort the input array.
2.Apply binary search .
3.If the given minimum distance can able to place k cow perfectly then we will shrink the array from left.
 (low=mid+1).
4.OtherWise , shrink from the right. (high=mid-1).
5.return high as the answer bcz high is the max possible value.




*/ 