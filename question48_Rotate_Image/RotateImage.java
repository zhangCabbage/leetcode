package zhang.algorithm.leetcode.question48_Rotate_Image;
/**
 * 关于图形的旋转、以某一个规律来遍历等这类题型，注意把规律转化为代码的能力提升！！<br/>
 * 
 * @author zhang_zack
 * 
 */
public class RotateImage {
	/**
	 * <strong>此算法O(n^2) space, O(n^2) time</strong><br/>
	 * 顺时针旋转90度，虽然这个太简单了。但是仍有值得思考的东西！有没有空间复杂度为O(1)的算法呢？<br/>
	 * <br/>
	 * 20 / 20 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 0 ms<br/>
	 * 
	 * @param matrix
	 */
    public void rotate(int[][] matrix) {
    	int len = matrix.length;
        int[][] rotateTemp = new int[len][len];
        for(int i=0; i<len; i++){
        	for(int j=0; j<len; j++){
        		rotateTemp[i][j] = matrix[len-j-1][i];
        	}
        }
        for(int i=0; i<len; i++){
        	for(int j=0; j<len; j++){
        		matrix[i][j] = rotateTemp[i][j];
        	}
        }
    }
    /**
     * 空间复杂度为O(1)的算法<br/>
     * <br/>
     * 好像如下：把三个2旋转90度就到了三个1的地方，从内到外<br/>
     * 1114 <br/>
     * 2584 <br/>
     * 2674 <br/>
     * 2333 <br/>
     * @param matrix
     */
    public void rotate2(int[][] matrix){
    	int n = matrix.length;
    	int start = 0;
    	int end = n-1;
    	for(int i=0; i<n/2; i++){
    		//这里按从外到内一圈一圈来算
    		for(int j=0; j<end-start; j++){
    			//每向内一圈，那么start+1，end-1，那么下一圈长度-2，所以使用end-start比较合适
    			int temp = matrix[start][start+j];
    			matrix[start][start+j] = matrix[end-j][start];
    			matrix[end-j][i] = matrix[end][end-j];
    			matrix[end][end-j] = matrix[start+j][end];
    			matrix[start+j][end] = temp;
    		}
    		start++;
    		end--;
    	}
    }
	
	public static void main(String[] args){
		RotateImage test = new RotateImage();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		System.out.println("原始矩阵：");
		printMatrix(matrix);
		
		test.rotate(matrix);
		System.out.println("顺时针旋转90度后：");
		printMatrix(matrix);
		
		test.rotate2(matrix);
		System.out.println("再次顺时针旋转90度后：");
		printMatrix(matrix);
	}
	/**
	 * 打印二维矩阵
	 * @param matrix
	 */
	public static void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				System.out.print(matrix[i][j]);
				if(j != matrix.length-1){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
