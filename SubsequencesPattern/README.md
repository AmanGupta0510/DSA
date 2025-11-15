The question is asking about all the possible subsequences of n number of '0' and '1'.

Approach 1 (Using recursion and backtracking ):- 
A subsequence is a sequence that can be derived from another sequence by deleting some or none of the elements, without changing the order of the remaining elements. 
So to achieve this we can use the property of recursion and backtracking means we simply add '0' in the string and call recursion and whenever my bitsString length == n i simply add that bitsString into the result List and backtrack and so on...

Time And Space Complexity :-
Time -> O(2^n) as we did 2^n recursive calls.
Space -> O(1) if recursive call stack ignored.  
