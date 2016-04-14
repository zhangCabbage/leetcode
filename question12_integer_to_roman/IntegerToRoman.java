package zhang.algorithm.leetcode.question12_integer_to_roman;

/**
 * 
 * @author zhang_zack
 *
 */
public class IntegerToRoman {
	/**
	 * 罗马数字的规则：<br/>
	 * 1、罗马数字共有七个，即I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)<br/>
	 * 2、左大加右大减<br/>
	 * 3、上加线乘千<br/>
	 * 4、同样单位最多出现三次<br/>
	 * 5、罗马数字中只有1（I）、10（X）、100（C）等可重复递加，50（L）、500（D）等不可重复，否则表示两个数LXL（50+40和60+50）,而XC只能90<br/>
	 * <br/>
	 * 由阿拉伯数字转化为罗马数字<br/>
	 * 关于罗马数字的构成可以看我第13道题中注释说明。<br/>
	 * <br/>
	 * <br/>
	 * 我这个思路太复杂，我觉得我总会把问题复杂化，没有简单架构处理问题的能力<br/>
	 * 总结规律！
	 * <br/>
	 * <br/>
	 * 最后测试通过！10ms
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		StringBuffer sb = new StringBuffer();
		char[] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] romanValue = {1,    5,  10,   50, 100, 500, 1000};
		int limitMax = romanChar.length-1;
		
		while(limitMax>=0 && num>0){
			for(int i=limitMax; i>=0; i--){
				int tempDiv = num/romanValue[i];
				int tempMod = num%romanValue[i];
				if(tempDiv==0)continue;
				
				if(tempDiv<=3 && tempMod<4*((i==0)?1:romanValue[i-1])){
					//执行temp遍
					for(int j=0; j<tempDiv; j++){
						sb.append(romanChar[i]);
					}
					num = tempMod;
				}else{
					if(tempDiv>3){
						sb.append(romanChar[i]);
						sb.append(romanChar[i+1]);
						num = tempMod;
					}
					
					if(tempMod>=4*((i==0)?1:romanValue[i-1])){
						sb.append(romanChar[i-1]);
						sb.append(romanChar[i+1]);
						num = num - romanValue[i+1] + romanValue[i-1];
					}
				}
				
				limitMax = i-1;
				break;
			}
		}
		
        return sb.toString();
    }
	
	/**
	 * 一种更简单的解决方案，归纳规律。
	 * @param num
	 * @return
	 */
	public String intToRoman2(int num) {
		String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    StringBuffer sb = new StringBuffer();
	    sb.append(M[num/1000]).append(C[(num%1000)/100]).append(X[(num%100)/10]).append(I[num%10]);
	    return sb.toString();
	}
	
	public String intToRoman3(int num) {
		int[] key =      {1000,900,500, 400,100, 90, 50,  40, 10,   9,  5,   4,  1};
	    String[] value = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    String res = ""; 
	    int index = 0;
	    while(num != 0){
	        if(num - key[index]>=0){
	            res += value[index];
	            num = num - key[index];
	        }else{
	            index++;
	        }
	    }

	    return res;
	}
	
	public static void main(String[] args){
		IntegerToRoman test = new IntegerToRoman();
		System.out.println(test.intToRoman(4));
	}
}
