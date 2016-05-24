package zhang.algorithm.leetcode.question69_Self_Sqrt;

public class SelfSqrt {
	/**
	 * 这里我本来只是想试一试的，没想到这样就过了<br/>
	 * <br/>
	 * 1017 / 1017 test cases passed<br/>
	 * Status: Accepted<br/>
	 * Runtime: 2 ms，而且击败了 90.69% 的人<br/>
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		return (int) Math.sqrt(x);
	}

	/**
	 * 如何手动的处理这个问题？这里最好的办法是使用二分查找的方法，那又该如何使用呢？<br/>
	 * 当时的感觉就是有点思路，但是就是没找到路子<br/>
	 * <br/>
	 * <strong>结果</strong><br/>
	 * 1017 / 1017 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 4 ms，只击败了6.28%<br/>
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt2(int x) {
		int left = 1;
		int right = x / 2 + 1; // 这里为什么要+1，因为这是针对x=1的情况
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			// 要注意int一半的一半的平方可能超出int范围
			if ((long) mid * mid < x) {
				left = mid + 1;
			} else if ((long) mid * mid > x) {
				right = mid - 1;
			} else {
				return mid;
			}
		}

		return right;
	}
	
	/**
	 * 用牛顿法求一个数的平方根<br/>
	 * <strong>牛顿法</strong>(百度百科)、<strong>牛顿迭代法</strong>(百度百科)很值得看看，弄懂！<br/>
	 * 深度解说牛顿法适用于开根号的方法(http://www.nowamagic.net/librarys/veda/detail/2268)，这个链接中牛顿法讲的不是很清楚，详细解析见下面我自己写的部分。
	 * 但是其中提供最值得参考的信息是最后的扩展知识！<strong>求一个数开平方并取倒的算法！！！</strong><br/>
	 * <br/>
	 * 由牛顿法我们知道对于最高项次方大于2的f(x)，有x(n+1)=x(n)－f(x(n))/f'(x(n))<br/>
	 * 那么求一个数的平方根带入为f(x) = x^2-n = 0的求解，n为给定已知的数<br/>
	 * 最后我们就得到：X(k+1)=[X(k)+n/Xk]/2<br/>
	 * <br/>
	 * 1017 / 1017 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 3 ms,击败17%的人<br/>
	 * 
	 * @param num
	 * @return
	 */
	public int mySqrt3(int num) {
		if (num == 1)
			return 1;
		
		float y = 1;
		float old = 0;
		//前后两次变换的距离小于1，那么就说明已经到达需要的值了
		while ((int) (y - old) != 0) {
			old = y;
			y = (y + num / y) * 0.5f; // Iterative Convergence
		}
		int res = (int) y;
		
		return res * res > num ? res - 1 : res;//这里为什么会可能大于1?
	}

	public static void main(String[] args) {
		SelfSqrt test = new SelfSqrt();
		int x = 2147395599;
		System.out.println(test.mySqrt(x));
		System.out.println(test.mySqrt2(x));
		System.out.println(test.mySqrt3(x));
		System.out.println(Math.sqrt(x));
		
		
//		这是上面那个疑问的解答，为什么后来需要减1得原因！！！！因为有效位的不同，导致结果的不同！！
//		【float和double的区别】
//		单精度浮点数（float）与双精度浮点数（double）的区别如下：
//		（1）在内存中占有的字节数不同
//			单精度浮点数在机内占4个字节
//			双精度浮点数在机内占8个字节
//		（2）有效数字位数不同
//			单精度浮点数有效数字8位，也就是说小数点前后位数和为8位！！超过那么就截断，向前进位！
//			双精度浮点数有效数字16位，小数点前后数位和为16位！！
//		（3）所能表示数的范围不同
//			单精度浮点的表示范围：-3.40E+38 ~ +3.40E+38
//			双精度浮点的表示范围：-1.79E+308 ~ +1.79E+308
//		（4）在程序中处理速度不同
//			一般来说，CPU处理单精度浮点数的速度比处理双精度浮点数快
		int m = 2147395599;
		int n = 46340;
		n = m/n;
		System.out.println("n--->"+n);//n--->46339
		
		int a = 2147395599;
		float b = 46340;
		b = a/b;
		System.out.println("b--->"+b);//b--->46340.0
		
		int p = 2147395599;
		double q = 46340;
		q = p/q;
		System.out.println("q--->"+q);//q--->46339.99997842037
	}
}
