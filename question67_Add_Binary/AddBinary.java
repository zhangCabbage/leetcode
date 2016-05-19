package zhang.algorithm.leetcode.question67_Add_Binary;

public class AddBinary {
	/**
	 * AC--->3ms<br/>
	 * so easy!
	 * @param a
	 * @param b
	 * @return
	 */
    public String addBinary(String a, String b) {
    	char[] a1 = toInteger(a.toCharArray());
    	char[] b1 = toInteger(b.toCharArray());
    	int aIndex = a1.length-1;
    	int bIndex = b1.length-1;
    	int len = a1.length>b1.length?a1.length:b1.length;
    	char[] res = new char[len+1];
    	int next = 0;
    	while(aIndex>=0 && bIndex>=0){
    		int sum = a1[aIndex--]+b1[bIndex--]+next;
    		res[len--] = (char) (sum%2);
    		next = sum/2;
    	}
    	while(aIndex >= 0){
    		int sum = a1[aIndex--]+next;
    		res[len--] = (char) (sum%2);
    		next = sum/2;
    	}
    	while(bIndex >= 0){
    		int sum = b1[bIndex--]+next;
    		res[len--] = (char) (sum%2);
    		next = sum/2;
    	}
    	if(next != 0){
    		res[len] = (char) next;
    	}
    	String str = toChar(res);
    	while(str.charAt(0)=='0' && str.length()>1){
    		str = str.substring(1);
    	}
        return str;
    }
    
	private String toChar(char[] res) {
		for(int i=0; i<res.length; i++){
			res[i] = (char) (res[i]+'0');
		}
		return new String(res);
	}


	private char[] toInteger(char[] c) {
		for(int i=0; i<c.length; i++){
			c[i] = (char) (c[i]-'0');
		}
		return c;
	}


	public static void main(String[] args){
		AddBinary test = new AddBinary();
		String a = "0";
		String b = "1";
		System.out.println(test.addBinary(a, b));
	}
}
