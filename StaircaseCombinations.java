public class StaircaseCombinations {

    // Function to calculate the number of ways to reach the top
    public static int countWays(int n) {
        int count = 0;

        // Iterate over the possible number of 2-steps we can use
        for (int k = 0; k <= n / 2; k++) {
            // The remaining steps will be filled with 1-steps
            int remainingSteps = n - 2 * k;
            
            // Each k represents a unique way to arrange the 2-steps and 1-steps
            // when order does not matter
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 4; // Example input
        int ways = countWays(n);
        System.out.println("Number of ways to reach the top of " + n + " stairs: " + ways);
    }
}
