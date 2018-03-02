package com.leetcode.array;

public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {5,3,5};
		System.out.println(removeElement(nums,5));;
	}

	public static int removeElement(int[] nums, int val) {
		
		int moveIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=val) {
				nums[moveIndex]=nums[i];
				moveIndex++;
			}
		}
		return moveIndex++;
	}
}
