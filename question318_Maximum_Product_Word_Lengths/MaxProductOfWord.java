package zhang.algorithm.leetcode.question318_Maximum_Product_Word_Lengths;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/28
 * Time: 下午6:55
 * To change this template use File | Settings | File Templates.
 */
public class MaxProductOfWord {
    /**
     * I think this problem can use union-find to solve.
     * So let's do it!
     * 我理解错了, 不能这样做, 没法解决!
     * eg: "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
     * <p>
     * 下一次, 请分析好后, 再开始行动, 我谢你了我的哥!!
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int[] lens = new int[26];
        make();
        for (String word : words) {
            if (word.length() == 0) continue;
            for (int i = 1; i < word.length(); i++) {
                union(word.charAt(0), word.charAt(i));
            }
            int root = find(word.charAt(0));
            if (lens[root] < word.length()) lens[root] = word.length();
        }

        int first = 0, second = 0;
        for (int i = 0; i < lens.length; i++) {
            if (lens[i] > first) first = lens[i];
            else if (lens[i] > second) second = lens[i];
        }

        return first * second;
    }

    /**
     * ==================================================
     * So then what should we do ?
     * ==================================================
     * Time Limit Exceeded.
     *
     * @param words
     * @return
     */
    public int maxProduct2(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].length() == 0) continue;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() == 0) continue;
                make();
                String first = words[i];
                for (int k = 1; k < first.length(); k++) {
                    union(first.charAt(0), first.charAt(k));
                }
                String second = words[j];
                for (int k = 1; k < second.length(); k++) {
                    union(second.charAt(0), second.charAt(k));
                }
                if (find(first.charAt(0)) != find(second.charAt(0))) {
                    max = Math.max(first.length() * second.length(), max);
                }
            }
        }
        return max;
    }

    private int[] father = new int[26];
    private int[] rank = new int[26];

    private void make() {
        for (int i = 0; i < 26; i++) {
            father[i] = i;
            rank[i] = 1;
        }
    }

    public int find(char a) {
        int i = a - 'a';
        if (father[i] != i) {
            father[i] = find((char) (father[i] + 'a'));
        }
        return father[a - 'a'];
    }

    public int union(char a, char b) {
        int i = find(a);
        int j = find(b);
        if (i != j) {
            if (rank[i] < rank[j]) {
                father[i] = j;
                return j;
            } else {
                father[j] = i;
                if (rank[i] == rank[j]) rank[i]++;
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        MaxProductOfWord test = new MaxProductOfWord();
        String[] strs = {"abcw", ""};
//        System.out.println(test.maxProduct(strs));
        System.out.println(test.maxProduct2(strs));
    }
}
