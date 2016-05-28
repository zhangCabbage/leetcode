package zhang.algorithm.leetcode.question77_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/5/28.
 */
public class Combinations {
    /**
     * 本题要考察回溯的思想.
     * <strong>测试结果:</strong>
     * 26 / 26 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 2 ms,击败了87.27%<br/>
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int[] original = new int[n+1];
        for(int i=1; i<=n; i++){
            original[i] = i;
        }

        listAllCombine(result, original, 1, k);

        return result;
    }

    private void listAllCombine(List<List<Integer>> result, int[] original, int start, int k) {
        if(k == 0){
            List<Integer> list = new ArrayList<Integer>();
            for(int i=1; i<original.length; i++){
                if(original[i] == -1){
                    list.add(i);
                }
            }
            result.add(list);
        }else{
            for(int i=start; i<original.length; i++){
                original[i] = -1;
                listAllCombine(result, original, i+1, k-1);
                original[i] = i;
            }
        }
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(test.combine(2, 1));
    }
}
