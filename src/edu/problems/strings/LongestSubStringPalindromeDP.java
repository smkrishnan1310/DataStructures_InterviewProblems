package edu.problems.strings;

import java.util.HashSet;
import java.util.Set;

import edu.ds.linear.Queue;

/**
 * 
 * Program to find Longest Substring Palindrome in the given String.
 * 
 * below 2 solutions provided both have worst case complexity of O(n^2) at best
 * case BFS is slightly better than recursive
 * 
 * We can find it in O(n) time complexity using Manacher's Algorithm
 * 
 */
public class LongestSubStringPalindromeDP {

	// Recursion
	public String find(String s) {
		if (null == s)
			return s;
		return findByRecursion(s, 0, s.length(), new HashSet<>());
	}

	// Recursion
	public String findByRecursion(String s, int st, int en, Set<String> set) {// Is used as memoize to avoid already
																				// processed keys
		String key = st + ":" + en;
		if (st < en && !set.contains(key)) {
			set.add(key);
			boolean isPali = isPalindrome(s, st, en);
			if (isPali)
				return s.substring(st, en);
			String s1 = findByRecursion(s, st + 1, en, set);
			String s2 = findByRecursion(s, st, en - 1, set);
			if (null == s1)
				return s2;
			if (null == s2)
				return s1;
			if (s1.length() > s2.length())
				return s1;
			return s2;
		}
		return null;
	}

	// Iterative method - BFS of the recursion tree
	public String findByBFS(String s) {
		if (null == s)
			return s;
		Set<String> set = new HashSet<>(); // Is used as memoize to avoid already processed keys

		Queue<Integer> q = new Queue<>();
		q.offer(0);
		q.offer(s.length());
		while (!q.isEmpty()) {
			int st = q.poll();
			int en = q.poll();
			String key = st + ":" + en;
			if (set.contains(key))
				continue;
			set.add(key);
			boolean isPali = isPalindrome(s, st, en);
			if (isPali)
				return s.substring(st, en);
			q.offer(st + 1);
			q.offer(en);
			q.offer(st);
			q.offer(en - 1);
		}
		return null;
	}

	public boolean isPalindrome(String s, int st, int end) {
		while (st < end) {
			if (s.charAt(st++) != s.charAt(--end))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		LongestSubStringPalindromeDP lcp = new LongestSubStringPalindromeDP();
		String input = "aas8#sdk#malayalam#ing$";
		String ans = lcp.find(input);
		System.out.println("Longest substring palindrome By recursion : " + ans);

		ans = lcp.findByBFS(input);
		System.out.println("Longest substring palindrome By Iteration : " + ans);
	}

}
