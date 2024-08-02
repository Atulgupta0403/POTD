public class EditDistance {
    
    public static int minDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create a DP array to memoize results of subproblems
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to insert all characters of second string
                if (i == 0) {
                    dp[i][j] = j;  // Min. operations = j
                }
                // If second string is empty, only option is to remove all characters of first string
                else if (j == 0) {
                    dp[i][j] = i; // Min. operations = i
                }
                // If last characters are the same, ignore the last character and recur for the remaining substring
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If last characters are different, consider all possibilities and find the minimum
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],  // Remove
                                    Math.min(dp[i][j - 1],  // Insert
                                             dp[i - 1][j - 1])); // Replace
                }
            }
        }
        
        // The final answer is in the bottom-right corner of the dp array
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";
        
        System.out.println("The minimum number of operations required to convert str1 to str2 is: " + minDistance(str1, str2));
    }
}
