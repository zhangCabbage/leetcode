package zhang.algorithm.leetcode.question62_Unique_Paths;

import java.util.Arrays;

public class UniquePaths {
	/**
	 * 采用递归回溯的方法来做此题，先不说我代码的结构是否优美，在题目要求的最大100*100的矩阵条件下会出现超时<br/>
	 * Time Limit Exceeded<br/>
	 * 本题提示：适合用动态规划的办法来做此题<br/>
	 * 
	 * @param m 行
	 * @param n 列
	 * @return
	 */
    public int uniquePaths(int m, int n) {
    	int result = 0;
    	if(m<1 || n<1){
        	return 0;
        }
        if(m==1 && n==1){
            return 1;
        }
        result += uniquePaths(m-1, n);
        result += uniquePaths(m, n-1);

        return result;
    }
	
    /**
     * 尝试使用动态规划的方法来解决当前问题，哈哈，并成功解决！！<br/>
     * <br/>
     * <strong>测试结果：</strong> <br/>
     * 61 / 61 test cases passed <br/>
     * Status: Accepted <br/>
     * Runtime: 1 ms，但是却只击败5.98%，sad <br/>
     * 
     * @param m 行
     * @param n 列
     * @return
     */
    public int uniquePaths2(int m, int n) {
    	//使用一个矩阵来存储起始到结束节点所有的路径数
    	int[][] paths = new int[m][n];
    	
    	//填充第一列
    	for(int i=0; i<m; i++){
    		paths[i][0] = 1;
    	}
    	//依次填充所有行
    	for(int i=0; i<m; i++){
    		if(i == 0){
    			Arrays.fill(paths[0], 1);
    		}else{
    			for(int j=1; j<n; j++){
        			paths[i][j] = paths[i-1][j]+paths[i][j-1];
        		}
    		}
    	}
        return paths[m-1][n-1];
    }
    
	public static void main(String[] args){
		UniquePaths test = new UniquePaths();
		int m = 23;
		int n = 12;
		
		long start1 = System.currentTimeMillis();
		System.out.println(test.uniquePaths(m, n));
		long end1 = System.currentTimeMillis();
		System.out.println("递归回溯总耗时---> "+(end1-start1)+"ms");
		
		long start2 = System.currentTimeMillis();
		System.out.println(test.uniquePaths2(m, n));
		long end2 = System.currentTimeMillis();
		System.out.println("动态规划总耗时---> "+(end2-start2)+"ms");
	}
}
