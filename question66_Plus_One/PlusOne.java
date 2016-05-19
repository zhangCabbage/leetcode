package zhang.algorithm.leetcode.question66_Plus_One;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int next = 1;
    	for(int i=digits.length-1; i>=0; i--){
    		int sum = next+digits[i];
    		digits[i] = sum%10;
    		next = sum/10;
    	}
    	if(next != 0){
    		int[] res = new int[digits.length+1];
    		res[0] = next;
    		for(int i=1; i<res.length; i++){
    			res[i] = digits[i-1];
    		}
    		return res;
    	}
    	
        return digits;
    }
    
    public static void main(String[] args){
    	PlusOne test = new PlusOne();
    	int[] digits = {9};
    	System.out.println(Arrays.toString(test.plusOne(digits)));
    }
}
