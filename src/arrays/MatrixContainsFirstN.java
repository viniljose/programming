package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 */
public class MatrixContainsFirstN {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j <n ; j++) {
                if(!row.add(matrix[i][j]) || !col.add(matrix[j][i]))
                    return false;
            }
        }
        return true;
    }
}
