package com.leetcode.stack;

import java.util.Stack;

/**
 * 
 * @Email:lifewikllbebest@163.com
 * @Question:
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 *                    ']', determine if the input string is valid.
 *                    </p>
 *                    <p>
 * 					The brackets must close in the correct order, "()" and
 *                    "()[]{}" are all valid but "(]" and "([)]" are not.
 *                    </p>
 * @URL:https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if(c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty()||stack.pop()!=c)
				return false;
		}
		return stack.isEmpty();
	}
	
	/**
	 * 主要用到stack(堆栈的先进后出的特性和合法的括号对应有的规律)，
	 * 字符串规律：一旦出现右括号那么出栈的必然是与之配对的左括号,
	 */
	
	public static void main(String[] args) {
		ValidParentheses valid = new ValidParentheses();
		System.out.println(valid.isValid("{[()]}"));
	}

}
