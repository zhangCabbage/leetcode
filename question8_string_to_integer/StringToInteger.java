package zhang.algorithm.leetcode.question8_string_to_integer;

/**
 * 由字符串转换成整数，比较出名的atoi函数，现在自己实现一个
 * @author DELL
 *
 */
public class StringToInteger {
	/**
	 * 要考虑全面，主要是对非法输入的控制。<br/>
	 * trim()可以去掉首尾空格、tab等非法字符<br/>
	 * 对于非法输入，需要提取其中最前面的正确数字<br/>
	 * 
	 * 不能简单的使用Integer.parseInt(str.trim());
	 * 
	 * @param str
	 * @return
	 */
	public int myAtoi(String str){
		int result=0;
		return result;
	}
	
	public static void main(String[] args){
		StringToInteger test = new StringToInteger();
		System.out.println(test.myAtoi(""));
		System.out.println("(\\d|\\-|\\+)*");
		System.out.println("-0012a42".matches("(\\d|\\-|\\+)*"));
	}
}
