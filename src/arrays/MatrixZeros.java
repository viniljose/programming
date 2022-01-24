package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatrixZeros {
    public static void main(String[] args) {
        MatrixZeros matrixZeros = new MatrixZeros();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        matrixZeros.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix1 = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        matrixZeros.setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

    }

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        Set rowTracker = new HashSet();
        Set colTracker = new HashSet();

        for (int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(matrix[i][j]==0){
                    rowTracker.add(i);
                    colTracker.add(j);
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if(rowTracker.contains(i) || colTracker.contains(j)){
                 matrix[i][j]=0;
                }
            }
        }

    }
}
