package zhang.algorithm.leetcode.question20_valid_parentheses;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * "([])"为true，这里使用了栈stack的数据结构
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		if(s.length()%2!=0)return false;
        Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
        	char currentChar = s.charAt(i);
        	if(currentChar=='('||currentChar=='['||currentChar=='{'){
        		stack.push(currentChar);
        	}else if((currentChar==')'&&!stack.isEmpty()&&stack.peek()=='(') || (currentChar==']'&&!stack.isEmpty()&&stack.peek()=='[') || (currentChar=='}'&&!stack.isEmpty()&&stack.peek()=='{')){
        		stack.pop();
        	}else{
        		return false;
        	}
        	
        }
		if(stack.isEmpty()){
			return true;
		}
		return false;
    }
	
	public static void main(String[] args){
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("])"));
	}
}
