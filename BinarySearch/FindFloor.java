// Question_Name -  Floor in a Sorted Array
// Problem_Link - https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
// PlatForm - GeeksForGeeks

package BinarySearch;
public class FindFloor {


    public int findFloor(int[] arr, int x) {
       
        int sI = 0;
        int eI = arr.length-1;
        while(sI<=eI){
            int mid = (eI-sI)+sI / 2;
            if(arr[mid] == x)return mid;
            else if(arr[mid] < x ){
                sI=mid+1;
            }
            else eI = mid-1;
        }
        return (eI>=0 && eI<arr.length ? eI : -1);
        
    }
}
/*
Explanation:
Approach 1  (Binary Search):

The appraoch is simple just use the normal binary search but it is there in the question the if 
the floor of x is missing in the array then return -1.
so, for this without using any variable we can do this just by applying some
conditions like if eI move out of the range of the array then there is no floor value of x exist 
in the array so in that case we will return -1.

Time_Complexity - O(logn)
Space_Complexity - O(1)


*/

