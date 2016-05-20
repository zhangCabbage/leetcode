package zhang.algorithm.leetcode.question49_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	/**
	 * 每一个内部list集合是按照字典顺序排列的。这里很明显每一个内部行所含的字母都是一样的，
	 * 我们能不能用类似信息摘要的形式来表征含有相同字母的一个字符串呢？<br/>
	 * <br/>
	 * 起初考察x^2+y^2+z^2 = l^2+m^2+n^2单是个三维空间中第一象限的球面，会有set(x, y, z)!=set(l, m,
	 * n)但却左右相等的情况，所以不能这样做！ 目前最烂的一种方法就是把拿到的每个字符串先排序，然后看原来是否含有此字符串。 <br/>
	 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], <br/>
	 * Return:<br/>
	 * [<br/>
	 * ["ate", "eat","tea"],<br/>
	 * ["nat","tan"],<br/>
	 * ["bat"]<br/>
	 * ]<br/>
	 * <strong>结果</strong><br/>
	 * 100 / 100 test cases passed.<br/>
	 * Status: Accepted<br/>
	 * Runtime: 20 ms<br/>
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> lists = new ArrayList<List<String>>();
		int index = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			char[] cur = strs[i].toCharArray();
			Arrays.sort(cur);
			// 这里需要注意一下，不要使用cur.toString()，对于数组这样toString只是把对象转换成String类型，而不是把对象对应的内容转换成String
			if (map.containsKey(String.valueOf(cur))) {
				List<String> list = lists.get(map.get(String.valueOf(cur)));
				int k = 0;
				for (; k < list.size(); k++) {
					if (!isAfter(list.get(k), strs[i])) {
						String temp = list.get(k);
						list.set(k++, strs[i]);
						while (k < list.size()) {
							String curTemp = temp;
							temp = list.get(k);
							list.set(k++, curTemp);
						}
						list.add(temp);
						break;
					}
				}
				if (k == list.size()) {
					list.add(strs[i]);
				}
			} else {
				// 如果未在里面
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				lists.add(list);
				map.put(String.valueOf(cur), index++);
			}
		}
		return lists;
	}

	/**
	 * 比较两个含有相同字符集的字符串<br/>
	 * 
	 * @param str
	 * @param cur
	 * @return
	 */
	private boolean isAfter(String str, String cur) {
		char[] strC = str.toCharArray();
		char[] curC = cur.toCharArray();
		for (int i = 0; i < strC.length; i++) {
			if (strC[i] > curC[i]) {
				return false;
			} else if (strC[i] < curC[i]) {
				return true;
			}
		}
		return true;
	}
	
	/**
	 * 上一个思路的改进版，上一个算法有不少毛病<br/>
	 * 1、针对相同字符集组成的字符串而言，其实根本不需要使用后期排序的isAfter函数，我们先进行排序，然后从前到后的取出排序后的String类型数据。
	 * string类型默认已经实现了Comparable接口。<br/>
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams2(String[] strs) {
		Arrays.sort(strs);
		
		List<List<String>> lists = new ArrayList<List<String>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String s: strs) {
			char[] cur = s.toCharArray();
			Arrays.sort(cur);
			List<String> list;
			// 这里需要注意一下，不要使用cur.toString()，对于数组这样toString只是把对象转换成String类型，而不是把对象对应的内容转换成String
			if (map.containsKey(String.valueOf(cur))) {
				list = lists.get(map.get(String.valueOf(cur)));
			} else {
				// 如果未在里面
				list = new ArrayList<String>();
				lists.add(list);
				map.put(String.valueOf(cur), lists.size()-1);
			}
			list.add(s);
		}
		return lists;
	}
	
	/**
	 * 跟我想的一个思路的，但是他最终找到成功辨别含有同样字符的字符串的方式<br/>
	 * 因为每个数都是素数，所以当set(x, y, z)!=set(l, m, n)时，x*y*z ！= l*m*n ！！！<br/>
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams3(String[] strs) {
		Arrays.sort(strs);
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };//这里表示26个字母对应的素数值
		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}

	public static void main(String[] args) {
		GroupAnagrams test = new GroupAnagrams();
		String[] strs = {"eatxyz", "teazyx", "tanasd", "aadsadfasfasfte", "sdsdsnat", "sdsffsdsfbat"};
		
		long start1 = System.currentTimeMillis();
		System.out.println(test.groupAnagrams1(strs));
		long end1 = System.currentTimeMillis();
		System.out.println("耗时----> "+(end1-start1)+"ms");
		
		long start2 = System.currentTimeMillis();
		System.out.println(test.groupAnagrams2(strs));
		long end2 = System.currentTimeMillis();
		System.out.println("耗时----> "+(end2-start2)+"ms");
		
		long start3 = System.currentTimeMillis();
		System.out.println(test.groupAnagrams3(strs));
		long end3 = System.currentTimeMillis();
		System.out.println("耗时----> "+(end3-start3)+"ms");
	}
}
