package StackAndQueues;

public class RemoveDuplicateCharacter {
    
/*
Explanation:
Appraoch 1 (Naive) - 
The appraoch to solve this problem is generate  string containing all character only once for each indx.
ex: "bcabc"
     b->bca
     c->cab
     a->abc 
     b->bc not considered bcz not contains all character
     c->c  not considered same as above
     after that find out the string which is smallest in lexicographical order.
the above appraoch will take O(n^2) time complexity.

Time Complexity - O(N^2)
Space Complexity - O(1)

Approach 2 (Better):
The 2nd and better approach is to maintain a monotonic stack such a way that the stack contains all such character
whcih are unique and lexicographically sorted.
See , the appraoch is simple whenver the peek() char is greater and its freq is > 0 than the curr char and curr char is not already in the stack then popped out the peek() we
apply these check condition so that the char in the stack are unique and should contains all unique character of the string.
And we only push those char character which are unvisited to maintain uniqueness in the ans.

Time Complexity - O(N)
Space Complexity - O(N)



 */
}
