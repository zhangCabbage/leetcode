package zhang.algorithm.leetcode.question64_Minimum_Path_Sum;

public class MinimumPathSum {
	/**
	 * 承接前面两道题，没有什么难度<br/>
	 * <br/>
	 * <strong>测试结果：</strong><br/>
	 * 61 / 61 test cases passed.
	 * Status: Accepted
	 * Runtime: 6 ms，只击败了10.84%
	 * @param grid
	 * @return
	 */
    public int minPathSum(int[][] grid) {
    	int m = grid.length;//行
    	int n = grid[0].length;//列
    	//首先操作第一行和第一列
    	for(int j=1; j<n; j++){
    		grid[0][j] += grid[0][j-1];
    	}
    	for(int i=1; i<m; i++){
    		grid[i][0] += grid[i-1][0];
    	}
    	
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			grid[i][j] += (grid[i-1][j]>grid[i][j-1]?grid[i][j-1]:grid[i-1][j]);
    		}
    	}
        return grid[m-1][n-1];
    }
	
	public static void main(String[] args){
		MinimumPathSum test = new MinimumPathSum();
		int[][] grid = {{0}};
		System.out.println(test.minPathSum(grid));
	}
}
