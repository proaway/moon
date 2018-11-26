package com.moon.senior.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * 
 * @author TobiasCui
 * @date 2018年11月23日 上午10:29:29
 * 
 */
public class TwoSum {

	public static int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) { // 第一个元素nums[i]不需要遍历到length次
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[] { 0, 0 };
	}
	
	 public static int[] twoSum3(int[] nums, int target) {
	        int[] result = new int[2];
	        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
	        for (int i = 0; i < nums.length; i++) {
	            if (map.containsKey(target - nums[i])) {
	                result = new int[]{map.get(target - nums[i]), i};
	            }
	            map.put(nums[i], i);
	        }
	        return result;
	    }

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 5, 7, 7, 11, 15 };
		System.out.println(nums.length);
		int target = 26;
		System.out.println(Arrays.toString(TwoSum.twoSum3(nums, target)));
	}

}
