package zhang.algorithm.leetcode.question70_Climbing_Stairs;

public class ClimbingStairs {
	/**
	 * 这里我第一次想的方法有问题，因为头脑状态先不思考，如果改进的办法。
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		int result = 0;

		int x = 0;
		int y = 0;
		for(; y<=n/2; y++){
			x = n-2*y;//这里还需要判断一下x是否为0
			if(x > 0){
				result += permutate(x, y);
			}else{
				result++;
			}
		}

		return result;
	}

	/**
	 * 专门用来计算阶乘，n!
	 * @param n
	 * @return
	 */
	public int factorial(int n){
		int result = 1;
		for(int i=2; i<=n; i++){
			result *= i;
		}
		return result;
	}
	
	/**
	 * 这里计算(x+y)!/(x!*y!)
	 * @param x
	 * @param y
	 * @return
	 */
	public int permutate(int x, int y){
		int big = Math.max(x, y);
		int small = Math.min(x, y);
		if(small == 0){
			return 1;
		}
		long result = 1;
		for(int i=(big+1); i<=(big+small); i++){
			result *= i;
		}
		for(int i=1; i<=small; i++){
			result /= i;
		}
		return (int)result;
	}
	
	/**
	 * 我真是个大傻叉，这道题用动态规划简直是相当简单！<br/>
	 * 我们假设a(n)表示到达第n级台阶所可能的所有方法和，因为每次我们能走1级或者2级台阶，所以易得递推公式：<br/>
	 * <br/>
	 * a(n) = a(n-2)+a(n-1)<br/>
	 * 这里我最开始的时候推导出错，通过配合程序演练才纠正原先的错误的！类似斐波拉契数列<br/>
	 * <br/>
	 * <strong>测试结果：</strong><br/>
	 * 45 / 45 test cases passed.
	 * Status: Accepted
	 * Runtime: 0 ms，只击败了17%
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
		int a = 1;
		if(n < 2){
			return a;
		}
		int b = 2;
		int temp;
		for(int i=3; i<=n; i++){
			temp = b;
			b = a+b;
			a = temp;
		}
		
		return b;
	}

	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		int n = 44;
		System.out.println(test.climbStairs(n));
		System.out.println(test.climbStairs2(n)); //1134903170
	}
}
