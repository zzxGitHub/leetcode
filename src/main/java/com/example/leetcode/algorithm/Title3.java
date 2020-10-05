package com.example.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassName Title3
 * @Description 无重复字符的最长子串 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @Author zzx
 * @Date 2020/10/5 9:25
 * @Version 1.0
 */
public class Title3 {

	/**
	 * 解法一：无法满足内存要求，超出了题目内存限制
	 */
	public int lengthOfLongestSubstring1(String s) {
		List<String> childSting = new ArrayList<>();
		// 求出所有的子串
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				childSting.add(s.substring(i, j));
			}
		}
		// 去重
		childSting = childSting.stream().distinct().collect(Collectors.toList());
		// 找到无重复字符的子串
		Iterator<String> it = childSting.iterator();
		while (it.hasNext()) {
			String re = it.next();
			if (re.length() == 1) {
				continue;
			} else {
				char[] ahcr = re.toCharArray();
				for (char a : ahcr) {
					// 如果包含
					if (re.indexOf(a) >= 0
							&& (re.substring(re.indexOf(a) + 1).contains(String.valueOf(a)))) {
						it.remove();
						break;
					}
				}
			}
		}
		// childSting.forEach(System.out::println);
		Optional<String> a = childSting.stream().max(Comparator.comparing(String::length));
		return a.map(String::length).orElse(0);
	}

	/**
	 * 解法二:依然超出内存限制，真滴拉跨
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		List<String> childSting = new ArrayList<>();
		// 求出所有的子串
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				childSting.add(s.substring(i, j));
			}
		}
		// 去重
		childSting = childSting.stream().distinct().collect(Collectors.toList());
		List<String> result = new ArrayList<>();
		for (String b : childSting) {
			List<String> resulta = new ArrayList<>();
			char[] ahcr = b.toCharArray();
			for (char c : ahcr) {
				resulta.add(String.valueOf(c));
			}
			List<String> resultb = resulta.stream().distinct().collect(Collectors.toList());
			if (resulta.size() == resultb.size()) {
				result.add(b);
			}
		}
		Optional<String> aaa = result.stream().max(Comparator.comparing(String::length));
		return aaa.map(String::length).orElse(0);
	}


	/**
	 * 解法三:循环遍历，用set判断重复字符，算是暴力破解吧，但是效率依旧差，但是能通过
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring3(String s) {
		Set<String> childSting = new HashSet<>();
		Set<Character> childChar = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			childChar.clear();
			childChar.add(s.charAt(i));
			childSting.add(String.valueOf(s.charAt(i)));
			for (int j = i + 1; j < s.length(); j++) {
				// 如果已包含此字符,跳出
				if (childChar.contains(s.charAt(j))) {
					break;
				} else {
					// 将不包含的字符加入
					childChar.add(s.charAt(j));
					childSting.add(s.substring(i, j + 1));
				}

			}
		}
		if (childSting.size() == 0) {
			return 0;
		}
		Optional<String> aaa = childSting.stream().max(Comparator.comparing(String::length));
		System.out.println(aaa.get());
		return aaa.map(String::length).orElse(0);
	}

	public static void main(String[] args) {
		Title3 title3 = new Title3();
		String data = "abcabcbb";
		int a = title3.lengthOfLongestSubstring3(data);
		System.out.println(a);
	}
}
