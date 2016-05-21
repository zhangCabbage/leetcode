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
	 * 这个方法还没看！
	 * @param x
	 * @return
	 */
	public int mySqrt3(int x) {
		if (x == 1)
			return 1;
		float y = 1;
		float old = 0;
		while ((int) (old - y) != 0) {
			old = y;
			y = (y + x * 1.0f / y) * 0.5f; // Iterative Convergence
		}
		int res = (int) y;
		return res * res > x ? res - 1 : res;// accommodate the Q
	}

	public static void main(String[] args) {
		SelfSqrt test = new SelfSqrt();
		int x = 2147483647;
		System.out.println(Long.MAX_VALUE);
		System.out.println(test.mySqrt(x));
		// System.out.println(Math.sqrt(x));
		System.out.println(test.mySqrt2(x));
	}
}
