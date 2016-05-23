package zhang.algorithm.leetcode.question59_Spiral_MatrixII;

public class SpiralMatrixII {
	/**
	 * 网页编辑器中完成，0ms，击败14.13%<br/>
	 * @param n
	 * @return
	 */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i=0;
        int j=0;
        int k=0;
        for(int len=0; len<=n/2; len++){
            for(i=len,j=len; j<n-len; j++)matrix[i][j] = ++k;
            for(i=len+1,j=n-1-len; i<n-len; i++)matrix[i][j] = ++k;
            for(i=n-1-len,j=n-2-len; j>=len; j--)matrix[i][j] = ++k;
            for(i=n-2-len,j=len; i>len; i--)matrix[i][j] = ++k;
        }
        return matrix;
    }
}
