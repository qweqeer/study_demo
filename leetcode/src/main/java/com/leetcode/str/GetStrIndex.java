package com.leetcode.str;

public class GetStrIndex {

	public static int strStr(String haystack, String needle) {

		if (null == needle || null == haystack)
			return -1;
		if (needle.isEmpty())
			return 0;
		
		//第一个字符的索引
		char c = needle.charAt(0);
		String firstStr = "";
		char[] chars = needle.toCharArray();
		for (int i=0;i<chars.length;i++) {
			if(chars[i]!=c) {
				firstStr = needle.substring(0, i+1);
				break;
			}
			else if(i ==chars.length-1&&chars[i]==c){
				firstStr = needle.substring(0, i+1);
				break;
			}
		}
		return haystack.indexOf(firstStr);
	}

	public static void main(String[] args) {
//		System.out.println(strStr("", ""));
//		System.out.println(strStr(null, ""));
//		System.out.println(strStr(null, null));
//		System.out.println(strStr("", null));
//		System.out.println(strStr("abc", "bca"));
//		System.out.println(strStr("abcccf", "ccff"));
//		System.out.println(strStr("mississippi","mississippii"));
		
	System.out.println(String.format("zhoux___%s",null));
	}
}
