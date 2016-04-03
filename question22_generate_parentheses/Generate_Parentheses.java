package zhang.algorithm.leetcode.question22_generate_parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generate_Parentheses {
	
	public List<String> list = new ArrayList<String>();
	public Map<String, Integer> mapKey = new HashMap<String, Integer>();
	
	/**
	 * 方法一：递归法求所有可能组合
	 * @param substr 已有串
	 * @param need 还需要几层遍历，need==1时为基准条件
	 */
	public void recursiveGenerator(String substr, int need){
		if(need>0){
			for(int i=0; i<=substr.length(); i++){
				StringBuffer sb = new StringBuffer();
				sb.append(substr.substring(0, i)).append("()").append(substr.substring(i, substr.length()));
				if(mapKey.containsKey(sb.toString())){
					continue;
				}
				mapKey.put(sb.toString(), 1);
				if(need==1){
					list.add(sb.toString());
				}
				recursiveGenerator(sb.toString(), need-1);
			}
		}
	}
	
	/**
	 * 方法二：采用回溯法求所有可能结果
	 * @param substr 已有串
	 * @param left 可用左括号数
	 * @param right 可用右括号数
	 */
	public void backTrackGenerator(String substr, int left, int right){
		System.out.println("left--> "+left+", right--> "+right);
		if(left>right){
			//这里体现回溯思想，当先用右括号时，最后的情况
			System.out.println("【left--> "+left+", right--> "+right+"】");
			return;
		}
		if(left>0){
			backTrackGenerator(substr+"(", left-1, right);
		}
		if(right>0){
			backTrackGenerator(substr+")", left, right-1);
		}
		if(left==0 && right==0){
			list.add(substr);
			return;
		}
	}
	
	public static void main(String args[]){
		int len = 3;
		Generate_Parentheses recursion1 = new Generate_Parentheses();
		
		System.out.println("递归方式得到全部组合：");
		long start1 = System.currentTimeMillis();
		recursion1.recursiveGenerator("", len);
		long end1 = System.currentTimeMillis();
		System.out.println(recursion1.list.size());
		System.out.println("用时："+(end1-start1)+"ms");
//		System.out.println(recursion1.list);
		
		System.out.println("回溯方式得到全部组合：");
		Generate_Parentheses recursion2 = new Generate_Parentheses();
		long start2 = System.currentTimeMillis();
		recursion2.backTrackGenerator("", len, len);
		long end2 = System.currentTimeMillis();
		System.out.println(recursion2.list.size());
		System.out.println("用时："+(end2-start2)+"ms");
//		System.out.println(recursion2.list);
	}
}
