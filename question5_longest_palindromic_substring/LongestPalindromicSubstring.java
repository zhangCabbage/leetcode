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
	
	public static void main(String[] args){
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		System.out.println(test.longestPalindrome(""));
	}
}
