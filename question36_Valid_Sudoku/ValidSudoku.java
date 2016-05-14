package zhang.algorithm.leetcode.question36_Valid_Sudoku;

import java.util.Arrays;

public class ValidSudoku {
	/**
	 * 现在只是验证这个初始的数独是否满足数独的三个条件：<br/>
	 * 1、每行为不重复1-9 <br/>
	 * 2、每列为不重复1-9 <br/>
	 * 3、每个九宫格为不重复1-9 <br/>
	 * AC--4 ms
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		int[] rowMap = new int[board.length];
		int[] colMap = new int[board.length];
		int[] cornerMap = new int[board.length];
		
		//每一行每一列不能有重复的1-9	
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				char curRow = board[i][j];
				char curCol = board[j][i];
				
				if(curRow != '.'){
					if(rowMap[curRow-'1']!=1){
						rowMap[curRow-'1'] = 1;
					}else{
						return false;
					}
				}
				if(curCol != '.'){
					if(colMap[curCol-'1']!=1){
						colMap[curCol-'1'] = 1;
					}else{
						return false;
					}
				}
				if(i%3==0 && j%3==0){
					Arrays.fill(cornerMap, 0);
					for(int m=0; m<3; m++){
						for(int n=0; n<3; n++){
							char curCorner = board[i+m][j+n];
							if(curCorner != '.'){
								if(cornerMap[curCorner-'1']!=1){
									cornerMap[curCorner-'1'] = 1;
								}else{
									return false;
								}
							}
						}
					}
				}
			}
			Arrays.fill(rowMap, 0);
			Arrays.fill(colMap, 0);
		}
		
        return true;
    }
	
	public static void main(String[] args){
		ValidSudoku test = new ValidSudoku();
		String[] strs = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char[][] board = new char[strs.length][];
		for(int i=0; i<strs.length; i++){
			board[i] = strs[i].toCharArray();
		}
		System.out.println(test.isValidSudoku(board));
	}
}
