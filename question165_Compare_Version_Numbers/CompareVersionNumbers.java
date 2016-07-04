package zhang.algorithm.leetcode.question165_Compare_Version_Numbers;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/4
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public class CompareVersionNumbers {
    /**
     *
     * <strong>result of test:</strong><br/>
     * 71 / 71 test cases passed
     * Status: Accepted
     * Runtime: 0 - 1 ms, bit 97.55% - 85.71%
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int index1 = 0, index2 = 0;
        int num1 = 0, num2 = 0;
        while (true) {
            char char1 = index1 < len1 ? version1.charAt(index1) : '.';
            char char2 = index2 < len2 ? version2.charAt(index2) : '.';

            if (char1 != '.') {
                num1 = num1 * 10 + (char1 - '0');
                index1++;
            }
            if (char2 != '.') {
                num2 = num2 * 10 + (char2 - '0');
                index2++;
            }

            if (char1 == '.' && char2 == '.') {
                if(index1 >= len1 && index2 >= len2){
                    break;
                }

                if (num1 < num2) {
                    return -1;
                } else if (num1 > num2) {
                    return 1;
                }

                num1 = num2 = 0;
                index1++;
                index2++;
            }
        }

        if (num1 < num2) {
            return -1;
        } else if (num1 > num2) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        String version1 = "0.1";
        String version2 = "1.0";
        System.out.println(test.compareVersion(version1, version2));
    }
}
