package zhang.algorithm.leetcode.question125_Valid_Palindrome;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/6/24
 * Time: 上午9:31
 * To change this template use File | Settings | File Templates.
 *
 * 我想要知道程序中那个地方最耗时,从而进行调优。
 *
 */
public class ValidPalindrome {
    /**
     * This programming is failure! You speed lot time and the code is not simple.
     * <strong>result of test:</strong><br/>
     * 476 / 476 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 15 ms, bit 25.18%<br/>
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        if (c.length < 1) return true;
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            if (!isAlphaNumeric(c[start])) {
                start++;
                continue;
            }
            if (!isAlphaNumeric(c[end])) {
                end--;
                continue;
            }
            if (c[start] == c[end]) {
                start++;
                end--;
                continue;
            } else {
                break;
            }
        }
        if (start >= end) return true;
        return false;
    }

    private boolean isAlphaNumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    //----------------------------------------------------------------------
    //About judgement whether a char is a alpha or a numeric or not
    //Here has a more better way
    //----------------------------------------------------------------------

    /**
     * this way is a little faster.
     * <p>
     * <strong>result of test:</strong><br/>
     * 476 / 476 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 12 ms, bit 34.75%<br/>
     *
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        char[] c = s.toLowerCase().toCharArray();
        if (c.length < 1) return true;
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            if (!(Character.isAlphabetic(c[start]) || Character.isDigit(c[start]))) {
                start++;
                continue;
            }
            if (!(Character.isAlphabetic(c[end]) || Character.isDigit(c[end]))) {
                end--;
                continue;
            }
            if (c[start] == c[end]) {
                start++;
                end--;
                continue;
            } else {
                break;
            }
        }
        if (start >= end) return true;
        return false;
    }

    //----------------------------------------------------------------------
    //more better way
    //----------------------------------------------------------------------
    /**
     *
     * <strong>result of test:</strong><br/>
     * 476 / 476 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 8 ms, bit 82.12%<br/>
     *
     * @param s
     * @return
     */
    public boolean isPalindrome3(String s) {
        if(s == null){
            return false;
        }
        if(s.length() <= 1){
            return true;
        }
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if(shouldIgnore(s.charAt(low))){
                low++;
                continue;
            }
            if(shouldIgnore(s.charAt(high))){
                high--;
                continue;
            }
            if(!isSameLetter(s.charAt(low), s.charAt(high))){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public boolean isLetter(char x){
        if(x>=65 && x<=90){
            return true;
        }
        if(x>=97 && x<=122){
            return true;
        }
        return false;
    }

    public boolean isSameLetter(char x, char y){
        if(isLetter(x) && isLetter(y)){
            if(x == y || x == y+32 || x+32 == y){
                return true;
            }
        }else{
            if(x == y){
                return true;
            }
        }
        return false;
    }

    public boolean shouldIgnore(char x){
        if(x >= 48 && x <= 57){
            return false;
        }
        return !isLetter(x);
    }


    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        String s = "a.";
        System.out.println(test.isPalindrome(s));
    }
}
