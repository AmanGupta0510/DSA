// Question_Name -  Rotate Image
// Problem_Link  -  https://leetcode.com/problems/rotate-image/ 
// PlatForm - LeetCode
package Arrays.Two_Pointers;
class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0;i<matrix.length;i++){
            for(int j = i;j<matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
        for(int i  = 0;i<matrix.length;i++){
            reverse(matrix[i]);
        }

    }
    private void reverse(int[] arr){

        int sI = 0;
        int eI = arr.length-1;
        while(sI<eI){
            int temp = arr[sI];
            arr[sI] = arr[eI];
            arr[eI] = temp;
            sI+=1;
            eI-=1;
        }

    }
}
/**
Explanation :
Approach 1 (Naive):
The first approach is to allocate a new matrix and in that newMatrix[0][0...] = matrix[n-1...][0]
Time_Complexity - O(m*n)
Space_Complexity - O(m*n)

Since the question clearly say do it in-place.

Approach 2 (Better):

The second approach is just to transpose the elment in the matrix.
transpose -> matrix[0][1] -> matrix[1][0] ans so on...
after transposing reverse all the rows of the matrix.

Time_Complexity - O(m*n)
Space_Complexity - O(1)


 */
