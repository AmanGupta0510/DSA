// Question_Name  - Sort an Array
// Problem_Link   -  https://leetcode.com/problems/sort-an-array/
// PlatForm - LeetCode

package PriorityQueues;
class Solution {
    // public int[] sortArray(int[] nums) {
        
    //     PriorityQueue<Integer> heap = new PriorityQueue<>();
    //     int i;
    //     for(i = 0;i<nums.length;i++){
    //         heap.add(nums[i]);
    //     }
    //     i = 0;
    //     while(!heap.isEmpty()){
    //         nums[i++] = heap.poll();
    //     }
    //     return nums;
    // }

    public int[] sortArray(int[] nums) {

        for(int i = 1;i<nums.length;i++){
            int temp = nums[i];
            int j = i-1;
            while(j>=0 && nums[j]>temp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
        return nums;

    }
}

/**
Explanation:
Appraoch 1 (Using min Heap):

The first approach is to put all the element in the min heap.
then one by one fetch out all element and place it in the array sequencially bcz we use min heap where elements are sorted in ascending order.

Time_Complexity - O(n*log(n))
Space_Complexity - O(logn) as we use priority queue to sort the array

Approach 2 (Insertion Sort):

Second approach is to use insertion Sort where tc is O(nlogn ) in the avg case.
but in this approach space is constant.
we can definetly do this by using other sorting algorithm like merge Sort,Quick Sort...  

 */