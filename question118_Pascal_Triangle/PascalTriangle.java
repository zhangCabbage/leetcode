package zhang.algorithm.leetcode.question118_Pascal_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/21.
 */
public class PascalTriangle {
    /**
     * generate pascal triangle(杨辉三角形), the time complexity is O(n^2)。
     * Could you make the time complexity of your AlgorithmDesign only O(n^2)?
     * <p>
     * <br/>
     * <strong>result of test:</strong><br/>
     * 15 / 15 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 40.47%<br/>
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            if (i != 0) {
                for (int k = 0; k < i; k++) {
                    int m = result.get(i - 1).get(k);
                    int n = (k + 1 < i) ? result.get(i - 1).get(k + 1) : 0;
                    list.add(m + n);
                }
            }

            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle test = new PascalTriangle();
        System.out.println(test.generate(3));
    }
}
