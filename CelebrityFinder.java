// A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people.  A square matrix mat is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

// Note: Follow 0-based indexing.


// Input: mat[][] = [[0 1 0],
// [0 0 0], 
// [0 1 0]]
// Output: 1
// Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity.



public class CelebrityFinder {
    
    // Method to find the celebrity
    public static int findCelebrity(int[][] mat) {
        int n = mat.length;
        int candidate = 0;
        
        // Identify the potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }
        
        // Verify the potential celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;  // Candidate is not a celebrity
            }
        }
        
        return candidate;  // Candidate is the celebrity
    }
    
    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };
        
        int celebrity = findCelebrity(mat);
        if (celebrity == -1) {
            System.out.println("There is no celebrity at the party.");
        } else {
            System.out.println("The celebrity is at index: " + celebrity);
        }
    }
}
