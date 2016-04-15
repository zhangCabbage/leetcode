package zhang.algorithm.leetcode.question14_longest_common_prefix;

/**
 * 
 * @author zhang_zack
 *
 */
public class LongestCommonPrefix {
	/**
	 * 5ms。题意没读懂的我，真是悲伤！
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        if(strs.length==1)return strs[0];
        StringBuffer sb = new StringBuffer();
        my:for(int i=0; i<strs[0].length(); i++){
            for(int j=1; j<strs.length; j++){
                if(strs[j].length()==i || strs[j].charAt(i) != strs[0].charAt(i)){
                    break my;
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
	
	public static void main(String[] args){
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] strs = new String[]{"a", "a", "b"};
		System.out.println(test.longestCommonPrefix(strs));
	}
}
