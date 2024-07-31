import java.util.ArrayList;
import java.util.List;

public class Spirally_Traversing_Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            // Traverse from left to right along the top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
}