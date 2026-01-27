// Question_Name - Replace elements by its rank in the array
// Problem_Link -  https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1
// PlatForm - GeeksForGeeks


package priorityQueues;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int k = 1;
        while(!pq.isEmpty()){
            int ele = pq.remove();
            // System.out.println(ele);
            map.put(ele,k);
            if(!pq.isEmpty() && ele!=pq.peek())k+=1;
        }
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i]))arr[i] = map.get(arr[i]);
        }
        return arr;
        
    }
    // static int[] replaceWithRank(int arr[], int N) {
        
    //     int[] sorted = arr.clone();
    //     Arrays.sort(sorted);
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     int k = 1;
    //     for(int i = 0;i<sorted.length;i++){
    //         if(i==0 || sorted[i]!=sorted[i-1]){
    //             map.put(sorted[i],k++);
    //         }
    //     }
        
    //     for(int i = 0;i<arr.length;i++){
    //         arr[i] = map.get(arr[i]);
    //     }
    //     return arr;
    // }
}
