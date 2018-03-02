package com.leetcode.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import com.alibaba.fastjson.serializer.CollectionCodec;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums= {1,1,1,3,3,5,6,6,78};
//		System.out.println(removeDuplicates(nums));
		
	    int length = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[length]) {
	        	length++;
	            nums[length] = nums[j];
	        }
	    }
	   
	   System.out.println(length + 1);
	}
	
	public static int removeDuplicates(int[] nums) {
		if(null == nums) return 0;
		if(nums.length<=1) return nums.length;
		int startIndex=0;
		while(startIndex < nums.length-1) {
			if(nums[startIndex] == nums[startIndex+1]) {	
				for(int i=startIndex;i<nums.length-1;i++) {
					if(nums[i]!=nums[i+1]) {
						for(int j = i;j<nums.length-1;j++) {
							nums[j]=nums[j+1];
						}
					}
				}
			}
			startIndex++;
		}
        int endIndex = nums.length-1;
        while(endIndex>0){
            if(nums[endIndex]!=nums[endIndex-1]){
                break;
            }else {
            		endIndex--;
            }
        }
		return endIndex+1;
    }
}
