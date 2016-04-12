package zhang.algorithm.leetcode.question7_reverse_integer;

public class ReverseInteger {
	
	/**
	 * 虽然简单，但是容易考虑不全面<br/>
	 * <br/>
	 * 正整数的反转，easy。其中主要需要考虑两点：<br/>
	 * 1、如果为100，那么反转后的值？1<br/>
	 * 2、如果输入的值大于int的范围该怎么办？返回0<br/>
	 * <br/>
	 * 我只考虑了前者，却没有考虑后者，所以编码的有问题！！！<br/>
	 * 半个小时后我终于知道自己问题出在哪里了。问题的根源根本不是上述第二点<br/>
	 * int的取值范围为：-2147483648～2147483647<br/>
	 * 如果传入的值并没有超出int规定范围，但是一反转则超出这个范围的可能性我漏判了。<br/>
	 * 比如：2147419999 --->  9999147412则超出范围<br/>
	 * <br/>
	 * 考虑不全面<br/>
	 * 使用字符串运行时间变慢5ms
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
        boolean nagativeTag = false;
        if(x<0) nagativeTag = true;
//        第一次改正并没有改对，传入的不可能是超过int范围的数值
//        if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE) return 0;
        int absNum = Math.abs(x);
        if(absNum/10==0) return x;
        StringBuffer sb = new StringBuffer();
        while(absNum/10!=0){
            sb.append(absNum%10);
            absNum = absNum/10;
        }
        sb.append(absNum);
        
        int result;
        try {
        	result = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			//如果转换成int出错，那么直接返回0
			result = 0;
			return result;
		}
        if(nagativeTag){
        	return -1*result;
        }
        return result;
    }
	
	/**
	 * 不使用String而是用自身int算，这样可以很好的控制越界错误的发生
	 * 2ms这个时间才算不错
	 * @param x
	 * @return
	 */
	public int reverse2(int x){
		long result = 0;
	    while (x != 0) {
	        result = result * 10 + x%10;
	        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
	            return 0;
	        }
	        x = x / 10;
	    }
	    return (int)result;
	}
	
	/**
	 * 用时2ms，还凑活<br/>
	 * <br/>
	 * 注意：<br/>
	 * System.out.println(-5/2);  //-2<br/>
	 * System.out.println(-5%2);  //-1<br/>
	 * System.out.println(5/-2);  //-2<br/>
	 * System.out.println(5%-2);  //1<br/>
	 * <br/>
	 * 除法只要有一个为负，结果为负<br/>
	 * 取余一定为要取余的数符号相同<br/>
	 * @param x
	 * @return
	 */
	public int reverse3(int x){
		return reverseRecursive(0, x);
	}
	
	public int reverseRecursive(int res, int x){
		if(x==0){
			return res;
		}
		long result = (long)res*10+x%10;
		if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
			return 0;
		}
		return reverseRecursive((int)result, x/10);
	}
	
	public static void main(String[] args){
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse3(-2147419999));
	}
}
