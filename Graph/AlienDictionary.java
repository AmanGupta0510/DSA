package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    // Question_Name - Alien Dictionary
// Problem_Link - https://www.geeksforgeeks.org/problems/alien-dictionary/1
// PlatForm - GFG



	public String findOrder(String[] words) {
		// code here
		
		int[] alphabets = new int[26];
		int uniqueCharCount = 0;
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				if (alphabets[ch - 'a'] == 0) {
					alphabets[ch - 'a'] = 1;
					uniqueCharCount++; // Keep track of how many unique chars exist
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> directedGraph = new ArrayList<>();
		
		for (int i = 0; i<26; i++) {
			directedGraph.add(new ArrayList<>());
		}
		
		for (int i = 0; i<words.length - 1; i++) {
			
			int j = 0;
			while (j<words[i].length() && j<words[i + 1].length() && words[i].charAt(j) == words[i + 1].charAt(j)) {
				j++;
			}
			if (j<words[i].length()
				 && j == words[i + 1].length())return "";
			if (j<words[i].length() && j<words[i + 1].length()) {
				directedGraph.get(words[i].charAt(j) - 'a').add(words[i + 1].charAt(j) - 'a');
			}
		} // mark all the dependencies in a directedGraph.
		
		// now calculate the indegree.
		int[] indegree = new int[26];
		for (int i = 0; i<directedGraph.size(); i++) {
			for (int j = 0; j<directedGraph.get(i).size(); j++) {
				indegree[directedGraph.get(i).get(j)]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i<26; i++) {
			if (indegree[i] == 0 && alphabets[i] != 0) {
				
				q.add(i);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-->0) {
				int index = q.poll();
				ans.append((char)(index + 'a'));
				for (int i = 0; i<directedGraph.get(index).size(); i++) {
					indegree[directedGraph.get(index).get(i)]--;
					if (indegree[directedGraph.get(index).get(i)] == 0)q.add(directedGraph.get(index).get(i));
				}
			}
		}
		
		if(ans.length()< uniqueCharCount)return "";
		return ans.toString();
		
	}
}

/*
Explanation:
Approach 1:(Kahn's Algorithm)
Steps:
1.track all the alphabets used in the dictionary by the alien and also keep track of uniqueCharacter as well;
2.Mark dependecies of character in the ArrayList.Dependencies occur when consecutive strings mismatch at any point. 
Note: If a longer word appears before its shorter prefix (e.g., "abcd" before "abc"), it's an invalid dictionary and we stop.
3.Calculte the indegree of those who has dependecies.
4.Apply topoSort.


Time_Complexity - O(N*M + V+E).
Space_Complexity - O(1)




*/

