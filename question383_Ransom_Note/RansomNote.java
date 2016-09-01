package zhang.algorithm.leetcode.question383_Ransom_Note;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/9/1
 * Time: 下午10:12
 * To change this template use File | Settings | File Templates.
 */
public class RansomNote {
    /**
     * aa, ab => false
     * aa, aab => true
     * <p>
     * 126 / 126 test cases passed
     * Status: Accepted
     * Runtime: 15 ms
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[128];
        for (char c : magazine.toCharArray()) {
            map[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (map[c] <= 0) return false;
            map[c]--;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote test = new RansomNote();
    }
}
