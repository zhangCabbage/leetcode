package zhang.algorithm.leetcode.question13_roman_to_integer;

public class RomanToInteger {
	
	/**罗马数字的规则：<br/>
	 * 1、罗马数字共有七个，即I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)<br/>
	 * 2、左大加右大减<br/>
	 * 3、上加线乘千<br/>
	 * 4、同样单位最多出现三次<br/>
	 * 5、罗马数字中只有1（I）、10（X）、100（C）等可重复递加，50（L）、500（D）等不可重复，否则表示两个数LXL（50+40和60+50）,而XC只能90<br/>
	 * 
	 * 从左往右，如果遇到数比左前面数大，那么就需要左减前面的数<br/>
	 * 如果依次小，那么直接一直累加即可
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int result=0;
		int len = s.length();
		int preNum = Integer.MAX_VALUE;
		int currentNum = 0;
		for(int i=0; i<len; i++){
			switch (s.charAt(i)) {
			case 'I':
				currentNum = 1;
				break;
			case 'V':
				currentNum = 5;
				break;
			case 'X':
				currentNum = 10;
				break;
			case 'L':
				currentNum = 50;
				break;
			case 'C':
				currentNum = 100;
				break;
			case 'D':
				currentNum = 500;
				break;
			case 'M':
				currentNum = 1000;
				break;
			default:
				break;
			}
			if(currentNum<=preNum){
				result += currentNum;
			}else{
				result = result-preNum+currentNum-preNum;
			}
			preNum = currentNum;
		}
        return result;
    }
	
	public static void main(String[] args){
		RomanToInteger test = new RomanToInteger();
		System.out.println(test.romanToInt("DCXXI"));
	}
}
