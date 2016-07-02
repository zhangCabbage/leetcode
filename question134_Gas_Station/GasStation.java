package zhang.algorithm.leetcode.question134_Gas_Station;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/2
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class GasStation {
    /**
     * Submission Result: Time Limit Exceeded
     * It`s easy to predict that this common way can not pass.
     * <p>
     * This problem tag is Greedy! But I can not think something about greedy.
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dis = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            dis[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < dis.length; i++) {
            if (dis[i] >= 0) {
                int sum = dis[i];
                for (int k = 1; k < dis.length; k++) {
                    sum += dis[(i + k) % dis.length];
                    if (sum < 0) break;
                }
                if (sum < 0) continue;
                return i;
            }
        }

        return -1;
    }

    /**
     * <strong>result of test:</strong><br/>
     * 16 / 16 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 5.48%<br/>
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) return -1;
        int sum = 0;
        int tempSum = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            sum += diff;
            tempSum += diff;
            if (tempSum < 0) {
                tempSum = 0;
                startPoint = i + 1;
            }
        }
        return sum < 0 ? -1 : startPoint;
    }

    public static void main(String[] args) {
        GasStation test = new GasStation();
        int[] gas = {2};
        int[] cost = {3};
        System.out.println(test.canCompleteCircuit2(gas, cost));
    }
}
