package zhang.algorithm.leetcode.question5_longest_palindromic_substring;

public class LongestPalindromicSubstring {
	/**
	 * 要求：找最长回文子字符串，S最长为1000，并且一定有唯一的一个最长回文字符串<br/>
	 * 
	 * 思路有问题！
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		char[] sChar = s.toCharArray();
		int len = sChar.length;
		if(len<3){
			return s;
		}
		int preIndex = 1;
		int currentIndex = 2;//当前下标
		boolean isMaybePalidrome = false;//是否可能有回文
		for(; currentIndex<sChar.length; currentIndex++){
			
			if(isMaybePalidrome){
				if(preIndex>=0 && sChar[currentIndex]==sChar[preIndex]){
					preIndex--;
				}else{
					isMaybePalidrome = false;
				}
			}else{
				
				if(sChar[currentIndex]==sChar[preIndex] && sChar[currentIndex]==sChar[preIndex-1]){
					
				}else if(sChar[currentIndex] == sChar[preIndex]){
					preIndex--;
				}else if(sChar[currentIndex] == sChar[preIndex-1]){
					
				}
			}
			
		}
		
        StringBuffer sb = new StringBuffer();
        return sb.toString();
    }
	
	/**
	 * 参考网上别人的思路，自己基本算是复制下来。时间复杂度为O(n^2) <br/>
	 * 10ms<br/>
	 * 当遍历一个字符的时候，找到此字符以后所有相同的字符间隔最远的下标，然后从这两边开始一一对应遍历
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		if(s==null){
			return "";
		}
		if(s.length()<3){
			return s;
		}
		int max = 0;
		int maxleft = 0;
		int maxRight = 0;
		char[] c = s.toCharArray();
		for(int i=0; i<c.length; ){
			int sameFurthestIndex = findSameFurthestIndex(c, i);
			int distance = getMaxDistance(c, i, sameFurthestIndex);
			
			int currLeft = i-distance;
			int currRight = sameFurthestIndex+distance;
			int currMax = currRight-currLeft+1;
			if(currMax>max){
				max = currMax;
				maxleft = currLeft;
				maxRight = currRight;
			}
			i = sameFurthestIndex+1;
		}
		return s.substring(maxleft, maxRight+1);
	}
	
	/**
	 * 找到回文两边对应的最远距离<br/>
	 * eg: bcdaaaadcb则返回3
	 * @param c 
	 * @param left 相同字符的左下标
	 * @param right 相同字符的右下标
	 * @return
	 */
	private int getMaxDistance(char[] c, int left, int right) {
		// TODO Auto-generated method stub
		int distance = 0;
		left--;
		right++;
		while(left>=0 && right<c.length){
			if(c[left--]==c[right++]){
				distance++;
			}else{
				break;
			}
		}
		return distance;
	}
	
	/**
	 * 找到从start下标开始字符完全相同的最远的右下标
	 * @param c
	 * @param start
	 * @return
	 */
	private int findSameFurthestIndex(char[] c, int start) {
		for(int index=start+1; index<c.length; index++){
			if(c[index]!=c[start]){
				return index-1;
			}
		}
		return c.length-1;
	}

	public static void main(String[] args){
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		System.out.println(test.longestPalindrome2("erebutitcanne"));
	}
}
