package edu.ds.nonlinear;

import edu.ds.nonlinear.utils.Comparator;

public class SimpleBinaryTree<T> {

	int size;
	TNode<T> root;

	Comparator<T> comp;

	SimpleBinaryTree(Comparator<T> comp) {
		this.comp = comp;
	}

	public void add(T data) {
		root = add(root, data);
		size++;
	}

	public TNode<T> add(TNode<T> node, T data) {
		if (node != null) {
			if (comp.compare(node.data, data) > 0) {
				node.right = add(node.right, data);
			} else {
				node.left = add(node.left, data);
			}
		}
		return new TNode<>(data);
	}

	public void printInOrder(TNode<T> root) {
		if (null != root) {
			printInOrder(root.left);
			System.out.print(root.data + ", ");
			printInOrder(root.right);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		SimpleBinaryTree<Integer> sbt = new SimpleBinaryTree<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return (a - b);
			}
		});
		for (int i : arr)
			sbt.add(i);
		System.out.println("Size: " + sbt.size);
		sbt.printInOrder(sbt.root);

	}

}
