package zhang.algorithm.leetcode.question9_palindrome_number;

/**
 * 回文数，意为正反读都相等的数字
 * @author zhang_zack
 *
 */
public class PalindromeNumber {
	
	/**
	 * 如何不占用额外空间的条件下判断出一个数为回文数？<br/>
	 * 注意：这道题规定负数不是回文<br/>
	 * 17ms时间有点长
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if(x<0)return false;
        if(x/10==0)return true;
        String str = new Integer(x).toString();
        int len = str.length();
        for(int i=0; i<len/2; i++){
        	if(str.charAt(i) != str.charAt(len-i-1)){
        		return false;
        	}
        }
        return true;
    }
	
	/**
	 * 在如何取得整数长度上做文章，看能不能加快速度<br/>
	 * 使用log10函数，13ms<br/>
	 * 貌似速度没有提升很多
	 * @param x
	 * @return
	 */
	public boolean isPalindrome2(int x) {
		//利用一些技巧可以做快速判断
		if(x<0) return false;
        if(x<10) return true;
        if(x%10==0) return false;
        if(x<100&&x%11==0) return true;
        if(x<1000&&((x/100)*10+x%10)%11==0) return true;
		
		int len = (int) Math.log10(x);
		int a = 1;
		int b = (int)Math.pow(10, len);
		for(int i=0; i<len/2+1; i++){
			if((x/a)%10 != (x/b)%10)return false;
			a*=10;
			b/=10;
		}
		return true;
	}
	
	public static void main(String[] args){
		PalindromeNumber test = new PalindromeNumber();
		System.out.println(test.isPalindrome(-2147447412));
	}
}
