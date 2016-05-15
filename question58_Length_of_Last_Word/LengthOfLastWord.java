package zhang.algorithm.leetcode.question58_Length_of_Last_Word;

public class LengthOfLastWord {
	/**
	 * so easy!
	 * @param s
	 * @return
	 */
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if(s=="" || strs.length == 0){
            return 0;
        }
        return strs[strs.length-1].length();
    }
	
	public static void main(String[] args){
		LengthOfLastWord test = new LengthOfLastWord();
		String s = "Hello World";
		System.out.println(test.lengthOfLastWord(s));
	}
}
