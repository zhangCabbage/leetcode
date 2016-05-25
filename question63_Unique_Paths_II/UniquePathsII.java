package zhang.algorithm.leetcode.question63_Unique_Paths_II;

public class UniquePathsII {
	/**
	 * 如果有障碍的话，简单在上一题的基础上变形就可以了，没有难度<br/>
	 * <br/>
	 * <strong>测试结果：</strong><br/>
	 * 43 / 43 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 1 ms<br/>
	 * @param obstacleGrid
	 * @return
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length; //行
    	int n = obstacleGrid[0].length; //列
    	int[][] paths = new int[m][n];
    	//首先给第一列和第一行给赋初值
    	for(int i=0; i<n; i++){
    		if(obstacleGrid[0][i] == 1){
    			break;
    		}
    		paths[0][i] = 1;
    	}
    	for(int i=0; i<m; i++){
    		if(obstacleGrid[i][0] == 1){
    			break;
    		}
    		paths[i][0] = 1;
    	}
    	
    	for(int i=1; i<m; i++){
    		for(int j=1; j<n; j++){
    			if(obstacleGrid[i][j] == 1){
    				paths[i][j] = 0;
    			}else{
    				paths[i][j] = paths[i][j-1]+paths[i-1][j];
    			}
    		}
    	}
        return paths[m-1][n-1];
    }
    
    public static void main(String[] args){
    	UniquePathsII test = new UniquePathsII();
    	int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
    	System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
    }
}
