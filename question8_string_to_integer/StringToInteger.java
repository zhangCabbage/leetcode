package zhang.algorithm.leetcode.question8_string_to_integer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * int的取值范围为：-2147483648～2147483647<br/>
	 * 如果大于最大值，则返回最大值；如果小于最小值，直接返回最小值。
	 * 
	 * 不能简单的使用Integer.parseInt(str.trim());
	 * 取巧使用正则表达式，但是耗时略长37ms
	 * 
	 * @param str
	 * @return
	 */
	public int myAtoi(String str){
		long result=0;
		Pattern pattern = Pattern.compile("((\\-|\\+)\\d{0,11})|(\\d{0,11})");
		Matcher matcher = pattern.matcher(str.trim());
		if(matcher.lookingAt()){//从开头开始比较
			try {
				result = Long.parseLong( matcher.group(0) );
			} catch (Exception e) {
				result = 0;
			}
			if(result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
			if(result<Integer.MIN_VALUE)return Integer.MIN_VALUE;
		}else{
			result = 0;
		}
		return (int)result;
	}
	
	/**
	 * 不使用正则表达式，而是手动处理字符串速度更快<br/>
	 * 5ms
	 * @param str
	 * @return
	 */
	public int myAtoi2(String str){
		str = str.trim();
		int len = str.length();
		int num=0;
		int i=0;
		int flag = 1;
		while(i<len){
			if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				if(i>8){
					long temp = num;
					temp = temp*10+str.charAt(i)-48;
					if(temp>2147483647L && flag==1)return Integer.MAX_VALUE;
					if(temp>2147483648L && flag==-1)return Integer.MIN_VALUE;
					num = (int)temp;
					i++;
					continue;
				}
				num = num*10+str.charAt(i++)-48;
			}else if(str.charAt(i)=='-' && i==0){
				flag = -1;
				i++;
			}else if(str.charAt(i)=='+' && i==0){
				i++;
			}else{
				i = len;
			}
		}
		return flag*num;
	}
	
	public static void main(String[] args){
		StringToInteger test = new StringToInteger();
		System.out.println(test.myAtoi("2147483648"));
		System.out.println(test.myAtoi2("123"));
	}
}
