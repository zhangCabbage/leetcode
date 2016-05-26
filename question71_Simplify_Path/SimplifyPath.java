package zhang.algorithm.leetcode.question71_Simplify_Path;

/**
 * Created by zhang_zack on 16/5/26.
 */
public class SimplifyPath {
    /**
     * <strong>测试结果:</strong>
     * 252 / 252 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 18 ms,只击败了12.7%<br/>
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        System.out.println(paths.length);
        String[] stack = new String[paths.length];
        int top = 0;
        for(int i=0; i<paths.length; i++){
            switch (paths[i]){
                case "":
                case ".":
                    break;
                case "..":
                    if(top>0){
                        top--;
                    }
                    break;
                default:
                    stack[top++] = paths[i];
            }
        }
        StringBuffer res = new StringBuffer();
        if(top == 0) res.append("/");
        for(int i=0; i<top; i++){
            res.append("/");
            res.append(stack[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        SimplifyPath test = new SimplifyPath();
//        String path = "/a/./b/../../c/";
//        System.out.println(test.simplifyPath(path));
        test2();
    }

    /**
     * 用来测试split是如何划分的,时间太长,我也忘了!<br/>
     * 对于"/12/" ==> "[]/[12]/"<br/>
     * 注意string.split的划分.[java 字符串split有很多坑，使用时请小心！！](http://yinny.iteye.com/blog/1750210)
     */
    public static void test1(){
        System.out.println("/12////");
        String[] strs = "/12////".split("/");
        System.out.println(strs.length);
        System.out.println("-----test start------");
        for(String str:strs){
            System.out.println(str);
        }
        System.out.println("-----test end------");
    }
    public static void test2(){
        String[] strs = "/12//".split("//");
        System.out.println(strs.length);
        System.out.println("-----test start------");
        for(String str:strs){
            System.out.println(str);
        }
        System.out.println("-----test end------");
    }
}
