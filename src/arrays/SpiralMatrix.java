package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralMatrix.spiralOrder(matrix));

        int[][] matrix1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralMatrix.spiralOrder(matrix1));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List result = new ArrayList();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up =0;
        int down = rows -1;
        int left = 0;
        int right = columns-1;

        while (result.size()<rows*columns) {

            // Traverse from left to right.
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            // Traverse downwards.
            for (int i = up+1; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            // Make sure we are now on a different row.
            if(up != down) {
                // Traverse from right to left.
                for (int i = right-1; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
            }
            // Make sure we are now on a different column.
            if(right != left) {
                // Traverse upwards.
                for (int i = down-1; i > up; i--) {
                    result.add(matrix[i][left]);
                }
            }
            up++;
            left++;
            down--;
            right--;
        }
        return result;
    }
}
