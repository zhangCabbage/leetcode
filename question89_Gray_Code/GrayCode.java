package zhang.algorithm.leetcode.question89_Gray_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/2.
 */
public class GrayCode {
    /**
     * 格雷码,每两个相邻的代码只有一个二进制位不同,这里注意了解下格雷码在现实生活中的应用场景<br/>
     * 但是这道题我没有想到有效的算法解决,通过百度百科倒是有对应的解决方案,针对其定义中的特点:反射码/循环码来生成
     * <br/>
     * 最后利用递推的原理做出来的,这道题目提示使用回溯来完成,具体方法有待探索<br/>
     *
     * <strong>测试结果:</strong><br/>
     * 12 / 12 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,击败18.16%<br/>
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        return recusiveGeneratorGrayCode(n);
    }

    private List<Integer> recusiveGeneratorGrayCode(int n) {
        List<Integer> grayList = new ArrayList<>();
        if(n == 0){
            grayList.add(0);
        }else if(n == 1){
            grayList.add(0);
            grayList.add(1);
        }else if(n > 1){
            grayList = recusiveGeneratorGrayCode(n-1);
            int len = grayList.size();
            for(int i=0; i<len; i++){
                grayList.add( grayList.get(len-i-1)|1<<(n-1) );
            }
        }

        return grayList;
    }

    /**
     * 还可以从自然数二进制编码直接转换成对应的格雷码的方式来解这道题<br/>
     * 二进制码→格雷码（编码）<br/>
     * 格雷码→二进制码（解码）该怎么转换?结合异或两次仍为自身的思想,进行解码<br/>
     * <br/>
     * 测试结果同上
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> grayList = new ArrayList<>();
        for (int i=0; i<(int)Math.pow(2, n); i++){
            grayList.add(i^i>>1);
        }
        return grayList;
    }

    /**
     * 利用卡诺图解决此问题,注意搞清楚[卡诺图]是什么东西!!!<br/>
     * 如何画出[卡诺图]?<br/>
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode3(int n) {
        List<Integer> grayList = new ArrayList<>();

        return grayList;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        int n = 1;
        System.out.println(test.grayCode(n));
        System.out.println(test.grayCode2(n));
    }
}
