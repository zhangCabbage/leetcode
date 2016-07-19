package zhang.algorithm.leetcode.question179_Largest_Number;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/13
 * Time: 下午10:02
 * To change this template use File | Settings | File Templates.
 */
public class LargestNumber {
    /**
     * this problem I think that can use the similar way that radix sort.
     * But I can not change it to fit this problem.
     * <p>
     * [reference other people](http://blog.csdn.net/xudli/article/details/42769549)
     * Thought : 更改快速排序的排序规则, 判断 a 、b 两个数的大小通过 a+b 与 b+a 的大小来比较得知。
     * <p>
     * 这里注意 : nums中可能有负数
     * <p>
     * <strong>result of test:</strong><br/>
     * 221 / 221 test cases passed
     * Status: Accepted
     * Runtime: 141 ms, bit 26.45%
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        Integer[] array = new Integer[nums.length];
        int i = 0;
        for (int num : nums) {
            array[i++] = num;
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer a1, Integer a2) {
                int l1 = (a1 == 0) ? 1 : (int) Math.log(Math.abs(a1)) + 1;
                int l2 = (a2 == 0) ? 1 : (int) Math.log(Math.abs(a2)) + 1;
                long aa1 = (long) (a1 * Math.pow(10, l2) + a2);
                long aa2 = (long) (a2 * Math.pow(10, l1) + a1);
                return aa1 > aa2 ? -1 : (aa1 == aa2 ? 0 : 1);
                //
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int num : array) {
            sb.append(num);
        }
        //注意如果这里数组所有的数都为 0 , 那么我们应该去除这些相同的。
        //replaceFirst()
        //注意这里正则表达式的意思 : 正则用的很有技术性, 学习一下
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }

    /**
     * this problem has another thought similar to deal it.
     * <p>
     * <strong>result of test:</strong><br/>
     * 221 / 221 test cases passed
     * Status: Accepted
     * Runtime: 140 - 145 ms, bit 28 - 18.76%
     *
     * @param nums
     * @return
     */
    public String largestNumber2(int[] nums) {
        int i = 0;
        String[] strs = new String[nums.length];
        for (int num : nums) {
            strs[i++] = String.valueOf(num);
        }
        Arrays.sort(strs, new Comparator<String>() {
            //这样想,正常排序应该是从小到大, 如果比较结果 a > b 跟一般结果不同,则返回负数
            //这是Comparator的结果
            @Override
            public int compare(String a, String b) {
                String lr = a + b;
                String rl = b + a;
                //对于String的compareTo
                //由于是str1.compareTo(str2), 所以当str1小于str2时, 那么返回负数
                return -lr.compareTo(rl);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }
        //注意如果这里数组所有的数都为 0 , 那么我们应该去除这些相同的。
        //replaceFirst()
        //注意这里正则表达式的意思 : 正则用的很有技术性, 学习一下
        return sb.toString().replaceFirst("^0+(?!$)", "");
    }

    /**
     * 221 / 221 test cases passed
     * Status: Accepted
     * Runtime: 130 ms, bit 65.01%
     *
     * @param nums
     * @return
     */
    public String largestNumber3(int[] nums) {
        if (nums == null || nums.length == 0)//Corner cases
            return "";

        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = Integer.toString(nums[i]);//Transfer int into String for comparation
        }
        Arrays.sort(str, new Comparator<String>() {//This is the main part
            public int compare(String s1, String s2)//compare two strings
            {
//There are three main types. len1 > len2, len2 > len1 and len1 = len2
                int len1 = s1.length();
                int len2 = s2.length();
                if (len1 > len2) {
/**If len1 > len2, like "1234" and "789", we just need to compare "123" and "789", right?
 the natural order of "789" is greater than "123" which corresponds to their int value order
 So, put 789 in front of 123 is the right way.
 */
                    int res = s1.substring(0, len2).compareTo(s2);
/**However, there is a special and tricky case that len1 > len2, and string1 startsWith string2
 eg "121" and "12", by comparing "12" and "12" we got a 0 which means equal.
 So we need to keep comparing the substring of string1 to string2 recursively to get the right answer.
 So, we compare "1"(which is s1.substring(len2)) to "12", and then compare"1" to "2", this sub case is actually included in len2>len1 case.
 */
                    return res == 0 ? compare(s1.substring(len2), s2) : -res;
                }
                if (len1 < len2) {
// This type is actually the same to type len1 > len2
                    int res = s2.substring(0, len1).compareTo(s1);
                    return res == 0 ? compare(s1, s2.substring(len1)) : res;
                } else
//If they are the same length, return the result of comparing their natural order.
                    return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            //Another tricky case, we have to make sure our string does not start with "0"
            if (sb.length() == 0 && s.startsWith("0"))
                continue;

            sb.append(s);
        }
        // If sb.length is 0, it means all numbers are 0, so, return "0", else return the string
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
