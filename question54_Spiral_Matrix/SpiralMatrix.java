package zhang.algorithm.leetcode.question54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/**
	 * return all elements of the matrix in spiral order ---> 返回矩阵的所有元素以螺旋顺序<br/>
	 * <br/>
	 * 22 / 22 test cases passed<br/>
	 * Status: Accepted<br/>
	 * Runtime: 1 ms，只击败了3.18%太弱了<br/>
	 * 
	 * @param matrix
	 * @return
	 */
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	int m = matrix.length;
    	if(m == 0){
    		return list;
    	}
    	int n = matrix[0].length;
    	
    	int k;
    	int i;
    	int j;
    	
    	for(k=0; k<Math.min(m, n)/2.0; k++){
    		//→
    		for(i=k,j=k; j<n-k; j++){
    			list.add(matrix[i][j]);
    		}
    		//↓
    		for(i++,j--; i<m-k; i++){
    			list.add(matrix[i][j]);
    		}
    		//← 当右回的时候，要判断是不是还在最初的那一行
    		for(i--,j--; i!=k&&j>=k; j--){
    			list.add(matrix[i][j]);
    		}
    		//↑ 当上回的时候，要判断是不是还在最初的那一列
    		for(i--,j++; j!=n-k-1&&i>k; i--){
    			list.add(matrix[i][j]);
    		}
    	}
        return list;
    }
    
    /**
     * 我自己的思路写出来的代码太臃肿，我想寻求借鉴更好的思路和代码组织方式！但是目前来看貌似没有<br/>
     * <br/>
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
    	List<Integer> list = new ArrayList<Integer>();
    	
        return list;
    }
	
	public static void main(String[] args){
		SpiralMatrix test = new SpiralMatrix();
		int[][] matrix = {{1,2},{3,4},{5,6}};
		System.out.println(test.spiralOrder(matrix));
	}
}
