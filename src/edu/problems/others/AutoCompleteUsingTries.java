package edu.problems.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> map = new HashMap<>();
	boolean isLast = false;
}

class Tries {

	TrieNode root = new TrieNode();

	public void add(String s) {
		if (s == null)
			return;
		// s = s.toLowerCase();
		TrieNode curr = root;
		for (int i = 0; i < s.length(); i++) {
			TrieNode next = curr.map.get(s.charAt(i));
			if (null == next) {
				next = new TrieNode();
				curr.map.put(s.charAt(i), next);
			}
			curr = next;
			if (i == s.length() - 1)
				curr.isLast = true;
		}
	}

	public List<String> find(String startsWith) {
		List<String> matches = new LinkedList<>();
		if (null == startsWith)
			return matches;
		// s = s.toLowerCase();
		TrieNode curr = root;
		for (int i = 0; i < startsWith.length(); i++) {
			TrieNode next = curr.map.get(startsWith.charAt(i));
			if (null == next)
				return matches;
			curr = next;
		}
		findAll(curr, startsWith, matches);
		return matches;
	}

	public void findAll(TrieNode root, String s, List<String> matches) {
		if (null != root) {
			if (root.isLast)
				matches.add(s);
			for (char i = ' '; i <= 'z'; i++) {
				TrieNode next = root.map.get(i);
				if (null != next)
					findAll(next, s + i, matches);
			}
		}
	}

}

public class AutoCompleteUsingTries {

	public static void main(String[] args) {
		Tries cities = new Tries();
		addSampleData(cities);
		String startsWith = "Co";
		cities.find(startsWith).forEach(v -> System.out.println(v));
	}

	private static void addSampleData(Tries cities) {
		cities.add("Vizag");
		cities.add("Lonovola");
		cities.add("Srinaga");
		cities.add("Colorado");
		cities.add("Austin");
		cities.add("Vijayawada");
		cities.add("Vilupuram");
		cities.add("Chicago");
		cities.add("New York");
		cities.add("Virudhunagar");
		cities.add("Thanjavur");
		cities.add("Pattukkottai");
		cities.add("Trivandrum");
		cities.add("New Delhi");
		cities.add("Tiruvanamalai");
		cities.add("Vancouver");
		cities.add("Patna");
		cities.add("Coorg");
		cities.add("Manali");
		cities.add("Trichy");
		cities.add("Tirupathi");
		cities.add("Toronto");
		cities.add("Chennai");
		cities.add("Shimla");
		cities.add("Bengaluru");
		cities.add("Madurai");
		cities.add("London");
		cities.add("Coimbatore");
		cities.add("Shivamoga");
		cities.add("Belfast");
		cities.add("Mysore");
		cities.add("Vatican City");
		cities.add("Berlin");
		cities.add("Thanjavur");
		cities.add("Thane");
		cities.add("New Port");
		cities.add("Mumbai");
		cities.add("New Jerssy");
		cities.add("Srirangam");
	}

}
