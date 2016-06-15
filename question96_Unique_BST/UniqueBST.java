package zhang.algorithm.leetcode.question96_Unique_BST;

import zhang.algorithm.modelUtil.ZhangUtil;


/**
 * Created by zhang_zack on 16/6/6.
 * 二叉查找树,也叫查找树,进一步有最优查找树
 */
public class UniqueBST {
    /**
     * 不用想,这个更是超时,这里我是想对比一下递归\递归加备忘录\动态规划之间在同一程序运行的差异<br/>
     * 所以我才想把递归的方法也写出来了!!
     * @param n
     * @return
     */
    public int numTrees0(int n) {
        if(n == 0){
            return 1;
        }
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += numTrees0(i-1)*numTrees0(n-i);
        }
        return sum;
    }

    /**
     * 我这样做,当在n=19的时候,时间超时,但是为什么呢?<br/>
     * 这种方法算是递归加备忘录优化
     * <br/>
     * <strong>测试结果:</strong><br/>
     * Time Limit Exceeded<br/>
     * @param n
     * @return
     */
    public int numTrees1(int n) {

        int[] temp = new int[n];
        temp[0] = 1;

        return recusiveFind(n, temp);
    }

    private int recusiveFind(int n, int[] temp){
        if(n <= 1){
            return 1;
        }

        int totalNum = 0;
        for(int i=1; i<=n; i++){
            int left = temp[i-1] != 0 ? temp[i-1] : recusiveFind(i-1, temp);
            int right = temp[n-i] != 0 ? temp[n-i] : recusiveFind(n-i, temp);

            int sum = left*right;
            totalNum += sum;
        }

        return totalNum;
    }

    /**
     * 使用动态规划的办法,从小到大的进行递推,这样只是两层循环
     * <br/>
     * <strong>测试结果:</strong><br/>
     * 19 / 19 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 0 ms,击败11.97%<br/>
     *
     * @param n
     * @return
     */
    public int numTrees2(int n) {

        int[] temp = new int[n+1];
        temp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                temp[i] += temp[j]*temp[i-j-1];
            }
        }
        return temp[n];
    }

    public static void main(String[] args) {
        UniqueBST test = new UniqueBST();
        int n = 22;

        ZhangUtil.setStartTime();
        System.out.println(test.numTrees0(n));
        System.out.println("递归耗时---->"+ZhangUtil.getIntervalTime()+"ms");

        ZhangUtil.setStartTime();
        System.out.println(test.numTrees1(n));
        System.out.println("递归加备忘录优化耗时---->"+ZhangUtil.getIntervalTime()+"ms");

        ZhangUtil.setStartTime();
        System.out.println(test.numTrees2(n));
        System.out.println("动态规划耗时---->"+ZhangUtil.getIntervalTime()+"ms");

//        当n为19时
//        1767263190
//        递归耗时---->2602ms
//        1767263190
//        递归加备忘录优化耗时---->1310ms
//        1767263190
//        动态规划耗时---->0ms

//        当n为22时
//        1288250424
//        递归耗时---->65861ms
//        1288250424
//        递归加备忘录优化耗时---->38758ms
//        1288250424
//        动态规划耗时---->0ms

//        可以看出备忘录优化后的递归方法比纯粹递归速度提高近一半,而动态规划则是质的提高
    }
}
