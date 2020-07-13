package edu.ds.nonlinear;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Print Tree in below forms 1. Vertically 2. Spirally/ Zig-Zag
 * 
 * For BFS and DFS please refer methods in Simple Binary Tree
 * 
 */
public class PrintTrees<T> {

	public void printVertically(TNode<T> root) {
		if (null != root) {
			Map<Integer, List<T>> map = new HashMap<>();
			printVertically(root, map, 0);
			map.forEach((x, y) -> System.out.println(x + " : " + y));
		}

	}

	private void printVertically(TNode<T> root, Map<Integer, List<T>> map, int num) {
		if (null != root) {
			List<T> list = map.get(num);
			if (null == list) {
				list = new LinkedList<>();
				map.put(num, list);
			}
			list.add(root.data);
			printVertically(root.left, map, num - 1);
			printVertically(root.right, map, num + 1);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 3, 1, 2, 4, 8, 6, 9, 7, 10, 0 };
		SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>((a, b) -> (b - a));
		for (int i : arr)
			tree.add(i);

		PrintTrees<Integer> printer = new PrintTrees<>();
		System.out.println("Print Trees vertically: ");
		printer.printVertically(tree.root);

	}

}
