package zhang.algorithm.leetcode.question50_Self_Pow;

public class SelfPow {
	/**
	 * 自己实现x^n的函数，这里使用普通方法肯定会超时！<br/>
	 * eg:x = 0.00001，y = 2147483647 <br/>
	 * 
	 * 300 / 300 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 21 ms，算法太差了，只击败了0.38%<br/>
	 * <br/>
	 * 这里一定要注意，当对可以为负的int类型数字进行取绝对值时，最小的int类型为-2147483648，而最大的int类型为2147483637，
	 * 这里会出问题！！
	 * 
	 * @param x
	 * @param n 次方，可能为正为负
	 * @return
	 */
	public double myPow(double x, int n) {
		double res = 1;
		if (Math.abs(x) == 1.0) {
			return (x > 0) ? res : (n % 2 == 1 ? -1 * res : res);
		}
		if (x == 0.0) {
			return 0.0;
		}

		long i = 0;
		for (; i < Math.abs((long) n); i++) {
			res *= (n > 0 ? x : 1 / x);
			res = Math.abs(res);
			if (res >= Double.MAX_VALUE) {
				res = Double.MAX_VALUE;
				break;
			} else if (res < Double.MIN_VALUE) {
				res = 0;
				break;
			}
		}
		if (x < 0 && n % 2 == 1) {
			return -1 * res;
		}
		return res;
	}

	/**
	 * 这道题跟question29题有类似的地方，主要是O(n)遍历时耗太长，我们使用类似二分法的办法来解决问题<br/>
	 * double类型占8个字节，64位<br/>
	 * 
	 * 300 / 300 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 2 ms。算法还是太弱，只击败了4.92%<br/>
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
		double res = 1;
		// 先整理一般的特殊情况
		if (x == 1.0) {
			return res;
		}
		if (x == 0.0) {
			return 0;
		}
		if (x == -1.0) {
			return (n % 2 == 0) ? 1 : -1;
		}

		double[] temp = new double[64];
		int len = -1;

		long absN = Math.abs((long) n);
		while ((long) 1 << (++len) <= absN) {
			temp[len] = x;
			x *= x;
		}
		for (int i = len - 1; i >= 0; i--) {
			int cur = 1 << i;
			if (absN >= cur) {
				res *= temp[i];
				absN -= cur;
			}
			if (absN == 0) {
				break;
			}
		}

		return (n > 0) ? res : 1 / res;
	}

	/**
	 * 采用类似二分查找的方式进行递归反而比上一个方法中递归要来的快<br/>
	 * <br/>
	 * 300 / 300 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 1 ms，击败30.73%<br/>
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow3(double x, int n) {
		if (x == 1) {
			return 1;
		} else if (x == -1) {
			if (n % 2 == 0)
				return 1;
			else
				return -1;
		}
		if (n == 0)
			return 1.00;
		if (n < 0)
			//如果n小于0的话，不能这样简单的处理，比如n等于-2147483648
			return 1.0 / (myPow3(x, -(n+1))*x);
		double half = myPow3(x, n >> 1);
		if (n % 2 == 0)
			return half * half;
		else
			return half * half * x;
	}

	public static void main(String[] args) {
		SelfPow test = new SelfPow();
		double x = 2.00000;
		int n = -2147483648;
		System.out.println(test.myPow(x, n));
		System.out.println(test.myPow2(x, n));
		System.out.println(test.myPow3(x, n));
		// double t = -(Double.MAX_VALUE+100);
		// System.out.println(t);
	}
}
