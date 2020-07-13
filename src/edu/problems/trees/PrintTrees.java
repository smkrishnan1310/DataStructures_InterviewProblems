package edu.problems.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.ds.linear.Stack;
import edu.ds.nonlinear.SimpleBinaryTree;
import edu.ds.nonlinear.TNode;

/**
 * Print Tree in below forms 1. Vertically 2. Spirally/ Zig-Zag
 * 
 * For BFS and DFS please refer methods in Simple Binary Tree
 * 
 */
public class PrintTrees<T> {

	// Method to print tree vertically
	public void printVertically(TNode<T> root) {
		if (null != root) {
			Map<Integer, List<T>> map = new HashMap<>();
			printVertically(root, map, 0);
			map.forEach((x, y) -> System.out.println(x + " : " + y));
		}

	}

	// Recursive call with left as -1 and right as 1
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

	public void printSpirally(TNode<T> root) {
		if (null != root) {
			Stack<TNode<T>> s1 = new Stack<>();
			Stack<TNode<T>> s2 = new Stack<>();

			s1.push(root);
			while (!s1.isEmpty() || !s2.isEmpty()) {
				while (!s1.isEmpty()) {
					TNode<T> node = s1.pop();
					System.out.print(node.data + ", ");
					if (null != node.left)
						s2.push(node.left);
					if (null != node.right)
						s2.push(node.right);
				}

				while (!s2.isEmpty()) {
					TNode<T> node = s2.pop();
					System.out.print(node.data + ", ");
					if (null != node.right)
						s1.push(node.right);
					if (null != node.left)
						s1.push(node.left);
				}
			}

		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 3, 1, 2, 4, 8, 6, 9, 7, 10, 0 };
		SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>((a, b) -> (b - a));
		for (int i : arr)
			tree.add(i);

		PrintTrees<Integer> printer = new PrintTrees<>();
		System.out.println("Print Trees vertically : ");
		printer.printVertically(tree.root);

		System.out.println("================");

		System.out.println("Print Trees Spirally/ ZigZag : ");
		printer.printSpirally(tree.root);

	}

}
