package zhang.algorithm.leetcode.question6_zigzag_conversion;

public class ZigzagConversion {
	/**
	 * 理解错误，我以为锯齿是如下格式，这种格式只有两种可能的行，很容易总结出规律。但是有问题！
	 * 
	 * & & & &
	 * &&&&&&&
	 * & & & &
	 * &&&&&&&
	 * & & & &
	 * 
	 * 正确的ZigZag格式如下，所示
	 * 
	 * &  &  &  &
	 * & && && &&
	 * && && && &
	 * &  &  &  &
	 * 
	 * 准确来说可能只是需要找到每行的规律来，遍历就好
	 * 
	 * @param s
	 * @param numRows 行数
	 * @return
	 */
	public String convert(String s, int numRows){
		int totalLen = s.length();
		int twoColNum = numRows+numRows/2;
		int colDivision = totalLen/twoColNum;
		int colRemainder = totalLen%twoColNum;
		int numCol = 0;//列数
		StringBuffer sb = new StringBuffer();
		
		if(colRemainder == 0){
			numCol = colDivision*2;
		}else if(colRemainder>0 && colRemainder<=numRows){
			numCol = colDivision*2+1;
		}else if(colRemainder>numRows && colRemainder<numRows+numRows/2){
			numCol = colDivision*2+2;
		}
		//按行进行遍历
		for(int i=0; i<numRows; i++){
			int beginIndex = i;
			int index = 0;//遍历时的列数
			if(i%2==0){
				//如果是奇数锯齿行
				while(index*2+1<=numCol && (beginIndex = i+index*twoColNum)<totalLen){
					index++;
					sb.append(s.substring(beginIndex, beginIndex+1));
				}
			}else{
				//如果是偶数正常行
				while(index<numCol && beginIndex<totalLen){
					index++;
					sb.append(s.substring(beginIndex, beginIndex+1));
					if(index%2==0){
						//如果是奇数列
						beginIndex = i+(index/2)*twoColNum;
					}else{
						//如果是偶数列
						beginIndex = (index/2)*twoColNum+numRows+i/2;
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 题意读懂后重新写的函数
	 * 由于思路有点混乱，没有把调理整理清楚，直接导致编码困难，无法进行下去！
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert2(String s, int numRows){
		int totalLen = s.length();
		int blockColNum = numRows*2-2;
		int colDivision = totalLen/blockColNum;
		int colRemainder = totalLen%blockColNum;
		int numCol = 0;//列数
		StringBuffer sb = new StringBuffer();
		if(colRemainder == 0){
			numCol = colDivision*(numRows-1);
		}else if(colRemainder>0 && colRemainder<=numRows){
			numCol = colDivision*(numRows-1)+1;
		}else if(colRemainder>numRows && colRemainder<blockColNum){
			numCol = colDivision*(numRows-1)+1+colRemainder-numRows;
		}
		//按行进行遍历
//		for(int i=0; i<numRows; i++){
//			int beginIndex = i;
//			int index = 0;//遍历时的列数
//			if(i%(==0){
//				while(index*2+1<=numCol && (beginIndex = i+index*twoColNum)<totalLen){
//					index++;
//					sb.append(s.substring(beginIndex, beginIndex+1));
//				}
//			}else if(i%(numRows-1)==1){
//				
//			}
//		}
		
		return sb.toString();
	}
	
	/**
	 * 参考桑海博文作者思路<br/>
	 * 作者博文地址：<a href="http://www.cnblogs.com/sanghai/p/3632528.html">ZigZag Conversion</a><br/>
	 * 思路新颖，代码量小<br/>
	 * 【总体思路】<br/>
	 * 采用由正常字符串铺排结果的方法，以对应的字符串数组来存放铺排的结果<br/>
	 * 当铺排结束，按照行优先顺序一行一行的读取出来，就是最后要求的结果。<br/>
	 * 
	 * @param s 要格式化的数组
	 * @param numRows 需要格式化的行数
	 * @return
	 */
	public String convert3(String s, int numRows){
		if(numRows==1) return s;
		StringBuffer[] sb = new StringBuffer[numRows];
		for(int i=0; i<numRows; i++){
			sb[i] = new StringBuffer();
		}
		int grap = numRows-2;//两个完整列中间的间隔
		int j=0;//
		for(int i=0; i<s.length();){
			//先铺排完整的numRows一列
			for(j=0; j<numRows&&i<s.length(); j++){
				sb[j].append(s.substring(i, i+1));
				i++;
			}
			//再铺排Z的一斜杠
			for(j=grap; j>0&&i<s.length(); j--){
				sb[j].append(s.substring(i, i+1));
				i++;
			}
		}
		//最后按行读取出格式化后完整结果
		for(int i=1; i<numRows; i++){
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
	}
	
	/**
	 * 也可以按照先前我的思路，总结出横着一行行需要读取的每个数位置下标的规律<br/>
	 * 1、完整列每次都需要读取出来<br/>
	 * 2、完整列同一行相邻列的两个数相差2*numRows-2<br/>
	 * 3、间隔出现的斜行数，与其相邻的右完整列数相差是有规律：承三角形的一层层叠加，相差2n<br/>
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert4(String s, int numRows){
		if(numRows<=1) return s;
		StringBuffer sb = new StringBuffer();
		int blockColNum = numRows*2-2;
		//按行读取最终结果
		for(int i=0; i<numRows; i++){
			int index = i;
			while(index<s.length()){
				sb.append(s.substring(index, index+1));
				int intervalIndex = index+blockColNum-2*i;
				if(i>0 && i<numRows-1 && intervalIndex<s.length()){
					//非第一和最后的两个数，都会有中间间隔数
					sb.append(s.substring(intervalIndex, intervalIndex+1));
				}
				index += blockColNum;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		ZigzagConversion test = new ZigzagConversion();
		System.out.println(test.convert3("PAYPALISHIRING", 3));
		System.out.println(test.convert4("PAYPALISHIRING", 3));
		//结果应该为PAHNAPLSIIGYIR
	}
}
