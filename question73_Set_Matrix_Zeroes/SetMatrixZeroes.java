package zhang.algorithm.leetcode.question73_Set_Matrix_Zeroes;

import zhang.algorithm.modelUtil.Array.ArrayTool;

import java.util.Arrays;

/**
 * Created by zhang_zack on 16/5/26.
 */
public class SetMatrixZeroes {
    /**
     * 157 / 157 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,击败了19.41%<br/>
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] tag = new int[n];
        for(int i=0; i<m; i++){
            boolean flag = false;//当前行是否需要置0
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    flag = true;
                    tag[j] = -1;
                }
            }
            if(flag == true){
                Arrays.fill(matrix[i], 0);
            }
        }
        for(int k=0; k<n; k++){
            if(tag[k] == -1){
                for(int i=0; i<m; i++){
                    matrix[i][k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes test = new SetMatrixZeroes();
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        ArrayTool.printIntMatrix(matrix);
        test.setZeroes(matrix);
        ArrayTool.printIntMatrix(matrix);
    }
}
