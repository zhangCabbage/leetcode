package zhang.algorithm.leetcode.question28_implement_subString;

public class Implement {
	/**
	 * 这道题找出needle字符串在haystack字符串中第一次出现的下标 <br/>
	 * 如果needle字符串不为haystack字符串的子串，那么返回-1 <br/>
	 * <br/>
	 * 很明显这里可以使用KMP算法啊<br/>
	 * <br/>
	 * AC---用时5ms
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if(needle.length()==0)return 0;
		int[] next = this.getNext(needle);
		int textIndex=0;
		int patternIndex = 0;
		char[] textChar = haystack.toCharArray();
		char[] patternChar = needle.toCharArray();
		while(textIndex<textChar.length && patternIndex<patternChar.length){
			if(patternIndex==-1 || textChar[textIndex] == patternChar[patternIndex]){
				textIndex++;
				patternIndex++;
			}else{
				patternIndex = next[patternIndex];
			}
		}
		if(patternIndex==patternChar.length){
			return textIndex-patternChar.length;
		}
        return -1;
    }
	
	/**
	 * 通过模式串计算，返回next数组
	 * @return
	 */
	public int[] getNext(String patternStr){
		char[] patternChar = patternStr.toCharArray();
		int[] next = new int[patternChar.length];
		next[0] = -1;
		int k = -1;//表示前缀下标
		int i = 0;//表示后缀下标
		while(i<patternChar.length-1){
			if(k==-1 || patternChar[i]==patternChar[k]){
				k++;
				i++;
				next[i] = k;
			}else{
				k = next[k];
			}
		}
		return next;
	}
	
	public static void main(String[] args){
		Implement test = new Implement();
		System.out.println(test.strStr("abc", "abc"));
	}
}
