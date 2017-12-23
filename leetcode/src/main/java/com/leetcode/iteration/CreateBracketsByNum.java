package com.leetcode.iteration;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @author lifewikllbebest@163.com
 * 
 * @title:Given n pairs of parentheses, write a function to generate all
 *              combinations of well-formed parentheses.
 * @url:https://leetcode.com/problems/generate-parentheses/description/
 *
 */
public class CreateBracketsByNum {
	public List<String> generateParenthesis(int num) {
		List<String> bracketsList = new ArrayList<String>();
		bracketsStr(bracketsList, "", 0, 0, num);
		return bracketsList;

	}

	private void bracketsStr(List<String> list, String str, int open, int close, int max) {
		if (str.length() == max * 2) {
			list.add(str);
			return;
		}
		//left must big then right
		if (open < max && open>=close)
			bracketsStr(list, str.concat("("), open + 1, close, max);
		if (close < max && open>=close)
			bracketsStr(list, str.concat(")"), open, close + 1, max);
	}

	public static void main(String[] args) {
		CreateBracketsByNum brackets = new CreateBracketsByNum();
		List<String> result = brackets.generateParenthesis(0);
		System.out.println(JSON.toJSON(result));

	}
}
