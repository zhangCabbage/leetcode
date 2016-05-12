package zhang.algorithm.leetcode.question29_divide_two_integers;

/**
 * 不使用乘、除、取余操作，求两个数相除的结果(商)
 * @author zhang_zack
 * @since 16/5/12
 * 
 */
public class DivideTwoIntegers {
	/**
	 * 这里要说一下，我很傻×的分不清<strong>被除数和除数的关系</strong>被除数/除数=商 <br/>
	 * <br/>
	 * 如果采用循环减法的形式来进行求商，这种方法肯定超时。比如：100000/1这种形式 <br/>
	 * <br/>
	 * 我用的是通过不断累加来靠近结果，直到取得最终值。以指数来靠近就会快很多了，首先让除数以2倍关系递增，然后直到刚好超过被除数。
	 * 在递增过程中保存除数递增的每个结果到一个数组里，并且保存刚好超过时的数组下标Max，数组的下标i就代表着这是2的i次方个除数
	 * 遍历Max-0，累加，如果累加中某一个和值大于了被除数，不加这个数，继续下一个，不大于则加上，为了无限靠近。
	 * 由于2^1 + 2^2 + … + 2^(n-1) = 2^n-1这个公式。累加过程中我们要同时累加数组下标代表的除数个数。最后返回即可。
	 * 
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		//TODO
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}else if(divisor == 1){
			return dividend;
		}else if(divisor == -1){
			if(dividend == Integer.MIN_VALUE){
				return Integer.MAX_VALUE;
			}else{
				return -dividend;
			}
		}else if(Math.abs((long)divisor) > Math.abs((long)dividend)){
			return 0;
		}
		int result = 0;
		long[] tempArr = new long[35];
		int len = -1;
		long absDividend = Math.abs((long)dividend);
		long absDivisor = Math.abs((long)divisor);
		
		while(absDivisor <= absDividend){
			tempArr[++len] = absDivisor;
			absDivisor = absDivisor<<1;
		}
		
		for(int i=len; i>=0; i--){
			if(absDividend < tempArr[0]){
				break;
			}
			if(tempArr[i]<=absDividend){
				absDividend -= tempArr[i];
				result += 1<<i;
			}
		}
		
		if((divisor>0&&dividend>0) || (divisor<0&&dividend<0)){
			return result;
		}else{
			return -result;
		}
    }
	
	public static void main(String[] args){
		DivideTwoIntegers test = new DivideTwoIntegers();
		int dividend = 2;
		int divisor = 2;
		System.out.println(test.divide(dividend, divisor));
	}
}
