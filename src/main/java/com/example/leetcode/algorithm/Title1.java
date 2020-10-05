package com.example.leetcode.algorithm;

/**
 * @ClassName Title1
 * @Description 两数之和
 * @Author zzx
 * @Date 2020/10/5 9:07
 * @Version 1.0
 */
public class Title1 {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15, 16};
		int target = 31;
		Title1 title1 = new Title1();
		title1.twoSum(nums, target);
	}
}
