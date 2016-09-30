package zhang.algorithm.leetcode.question402_Remove_K_Digits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/29
 * Time: 下午10:41
 * To change this template use File | Settings | File Templates.
 */
public class RemoveKDigits {
    /**
     * 思路还是挺容易的, 但是码起来竟然用了挺长时间, fuck
     * <p>
     * 这里有两个Python实现的代码,可以参考一下
     * [Short Python, one O(n) and one RegEx](https://discuss.leetcode.com/topic/59380/short-python-one-o-n-and-one-regex)
     * <p>
     * 30 / 30 test cases passed.
     * Status: Accepted
     * Runtime: 33 ms, bit 44.16%
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        List<Character> list = new ArrayList();
        for (int i = 0; i < num.length(); i++) {
            list.add(num.charAt(i));
        }
        int index = 0;
        int count = 0;
        while (index < list.size() - 1) {
            if (list.get(index) > list.get(index + 1)) {
                list.remove(index);
                count++;
                index = index == 0 ? index : index - 1;
                if (count == k) break;
            } else {
                index++;
            }
        }

        index = 0;
        while (index < k - count) {
            list.remove(list.size() - 1);
            count++;
        }

        index = 0;
        while (index < list.size() - 1) {
            if (list.get(index) != '0') break;
            else index++;
        }

        StringBuffer sb = new StringBuffer();
        for (char c : list) {
            sb.append(c);
        }
        return sb.substring(index, list.size());
    }

    //--------------------------------------------------------
    //python 代码
    //--------------------------------------------------------
//
//    def removeKdigits(self, num, k):
//      """ 正常思路 """
//      out = []
//      for c in num:
//          if k and out and out[-1] > c:
//              out.pop()
//              k--
//          out.append(c)
//      return ''.join(out.lstrip('0')) or '0'
//
//    def removeKdigits2(self, num, k):
//      """ 使用正则表达式的方式来解决这个问题, 简单明了 """
//      import re
//      sub = re.compile(r'1[0]|2[01]|3[0-2]|4[0-3]|5[0-4]|6[0-5]|7[0-6]|8[0-7]|9[0-8]|.$').sub
//      for _ in xrange(k):
//          num = sub(lambda m: m.group()[1:], num, 1)
//      return num.lstrip('0') or '0'

    public static void main(String[] args) {
        RemoveKDigits test = new RemoveKDigits();
        String num = "10";
        int k = 1;
        System.out.println(test.removeKdigits(num, k));
    }
}
