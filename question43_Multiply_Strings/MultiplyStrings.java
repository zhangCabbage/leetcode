package zhang.algorithm.leetcode.question43_Multiply_Strings;

public class MultiplyStrings {
	/**
	 * 最开始我想使用数论的方法来解决这个问题，思路如下：<br/>
	 * 4837*5261 分解成 (100*w+x)*(100*y+z) = 10000*w*y+100*(w*z+x*y)+x*z <br/>
	 * 那么让：<br/>
	 * r = (w+x)*(y+z) <br/>
	 * p = w*y <br/>
	 * q = x*z <br/>
	 * 则上式子变成 10000*p+100*(r-p-q)+q <br/>
	 * 可以看出这样不仅可以使用分治法进行算法递归，而且减少了乘法运算的次数，加快速度。<br/>
	 * <br/>
	 * 则需要实现：字符串乘法、字符串加法、字符串减法 <br/>
	 * 确实是实现了，但是算法怎么跑的太慢了！<br/>
	 * <br/>
	 * 311 / 311 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 170 ms<br/>
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
    public String multiply(String num1, String num2) {
    	if(num1.equals("0") || num2.equals("0")){return "0";}
    	if(num1.equals("1")){return num2;}
    	if(num2.equals("1")){return num1;}
    	
    	char[] num1Char = num1.toCharArray();
		char[] num2Char = num2.toCharArray();
    	if(num1Char.length==1 && num2Char.length==1){
    		Integer res = (num1Char[0]-'0')*(num2Char[0]-'0');
    		return res.toString();
    	}
    	
		int len = (num1.length()>num2.length())?num1.length():num2.length();
		int bit = len>>1;
		
		int mid1 = findMid(num1.length(), bit);
		int mid2 = findMid(num2.length(), bit);
		String w = (mid1>0)?num1.substring(0, mid1):"0";
		String x = (mid1>0)?num1.substring(mid1, num1.length()):num1;
		String y = (mid2>0)?num2.substring(0, mid2):"0";
		String z = (mid2>0)?num2.substring(mid2, num2.length()):num2;
		
		String r = multiply(addition(w, x), addition(y, z));
		String p = multiply(w, y);
		String q = multiply(x, z);
		return addition(addition(decadeMultiply(p, bit<<1), decadeMultiply(subtraction(subtraction(r, p), q), bit)), q);
    }
	private int findMid(int len, int bit){
		if(len-bit>0){
			return len-bit;
		}else{
			return -1;
		}
	}
	/**
	 * 字符串的加法 num1+num2
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String addition(String num1, String num2) {
		if(num1.equals("0")){return num2;}
    	if(num2.equals("0")){return num1;}
    	
		StringBuffer sb = new StringBuffer();
		char[] num1Char = num1.toCharArray();
		char[] num2Char = num2.toCharArray();
		int num1End = num1Char.length-1;
		int num2End = num2Char.length-1;
		int next = 0;
		
		while(num1End>=0 && num2End>=0){
			int a = num1Char[num1End--]-'0';
			int b = num2Char[num2End--]-'0';
			sb.insert(0, (a+b+next)%10);
			next = (a+b+next)/10;
		}
		while(num1End>=0){
			int a = num1Char[num1End--]-'0';
			sb.insert(0, (a+next)%10);
			next = (a+next)/10;
		}
		while(num2End>=0){
			int b = num2Char[num2End--]-'0';
			sb.insert(0, (b+next)%10);
			next = (b+next)/10;
		}
		if(next != 0){
			sb.insert(0, next);
		}
		return sb.toString();
	}
	/**
	 * 字符串的减法 num1-num2
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String subtraction(String num1, String num2) {
		if(num2.equals("0")){return num1;}
		
		StringBuffer sb = new StringBuffer();
		char[] num1Char = num1.toCharArray();
		char[] num2Char = num2.toCharArray();
		int num1End = num1Char.length-1;
		int num2End = num2Char.length-1;
		int next = 0;
		
		while(num1End>=0 && num2End>=0){
			int a = num1Char[num1End--]-'0';
			int b = num2Char[num2End--]-'0';
			sb.insert(0, (a-b-next)>=0?(a-b-next):(a-b-next+10));
			next = (a-b-next)>=0?0:1;
		}
		while(num1End>=0){
			int a = num1Char[num1End--]-'0';
			if(num1End==-1 && (a-next)==0){
				break;
			}
			sb.insert(0, (a-next)>=0?(a-next):(a-next+10));
			next = (a-next)>=0?0:1;
		}
		while(sb.length()>1 && sb.charAt(0)=='0'){
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	/**
	 * 表示字符串和10^bit相乘的结果字符串
	 * @param num
	 * @param bit
	 * @return
	 */
	private String decadeMultiply(String num, int bit){
		if(num.equals("0")){return num;};
		StringBuffer sb = new StringBuffer(num);
		for(int i=0; i<bit; i++){
			sb.append("0");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		MultiplyStrings test = new MultiplyStrings();
		String num1 = "1021";
		String num2 = "5";
		System.out.println(test.multiply(num1, num2));
	}
}
