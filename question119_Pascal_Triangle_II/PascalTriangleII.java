package zhang.algorithm.leetcode.question119_Pascal_Triangle_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhang_zack on 16/6/21.
 */
public class PascalTriangleII {
    /**
     * Here we use the way I see in the discuss of last problem
     * we also from top to bottom, but this time we only storage two rows.
     * <p>
     * Could you optimize your AlgorithmDesign to use only O(k) extra space?
     * <p>
     * <strong>result of test:</strong><br/>
     * 34 / 34 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 84.70%<br/>
     *
     * @param rowIndex actually we want (rowIndex+1)th
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0) return result;

        int[] temp = new int[rowIndex + 1];
        Arrays.fill(temp, 1);
        for (int i = 2; i <= rowIndex; i++) {
            int m = temp[0];
            int n = temp[1];
            for (int k = 1; k < i; k++) {
                temp[k] = m + n;
                m = n;
                n = temp[k + 1];
            }
        }

        for (int i = 0; i <= rowIndex; i++) {
            result.add(temp[i]);
        }
        return result;
    }
}
