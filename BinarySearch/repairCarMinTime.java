package BinarySearch;

public class repairCarMinTime {
    
    // Question_Name - Minimum Time to Repair Cars
// Problem_Link -  https://leetcode.com/problems/minimum-time-to-repair-cars/
// Platform - LeetCode

    public long repairCars(int[] ranks, int cars) {
        
       

        long sI = 0;
        long eI = Long.MAX_VALUE;
       
        while(sI<=eI){
            long mid = (eI+sI)/2;
            if(possible(ranks,cars,mid)){
                eI=mid-1;
            }
            else{
                sI=mid+1;
            }
        }
        return sI;
    }
    private boolean possible(int[] ranks,int cars,long time){

        long count = 0;
        for(int i = 0;i<ranks.length;i++){
            
           count+=(long)Math.sqrt(time/ranks[i]);
           if(count>=cars)return true;
          
       }
       return count>=cars;

    }
   
}

