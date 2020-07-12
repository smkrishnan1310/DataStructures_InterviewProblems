package edu.ds.nonlinear;

import edu.ds.linear.Queue;
import edu.ds.nonlinear.utils.Comparator;

/**
 * Example for
 * 
 * 1. Implementation Simple Binary Search Tree (Not Balanced) 
 * 2. DFS & BFS traversal
 * 
 */
public class SimpleBinaryTree<T> {

	int size;
	TNode<T> root;

	Comparator<T> comp;

	SimpleBinaryTree(Comparator<T> comp) {
		this.comp = comp;
	}

	public void add(T data) {
		TNode tNode = add(root, data);
		if (null == root)
			root = tNode;
		size++;
	}

	public TNode<T> add(TNode<T> node, T data) {
		if (node != null) {
			if (comp.compare(node.data, data) > 0) {
				node.right = add(node.right, data);
				return node;
			} else {
				node.left = add(node.left, data);
				return node;
			}
		}
		return new TNode<>(data);
	}

	//DFS 
	public void printInOrder(TNode<T> root) {
		if (null != root) {
			printInOrder(root.left);
			System.out.print(root.data + ", ");
			printInOrder(root.right);
		}
	}
	//DFS 
	public void printPreOrder(TNode<T> root) {
		if (null != root) {
			System.out.print(root.data + ", ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}
	//DFS 
	public void printPostOrder(TNode<T> root) {
		if (null != root) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data + ", ");
		}
	}

	// Level order - BFS
	public void printLevelOrder(TNode<T> node) {
		if (null != root) {
			Queue<TNode<T>> q = new Queue<>();
			q.offer(node);
			while (!q.isEmpty()) {
				TNode<T> tNode = q.poll();
				System.out.print(tNode.data+", ");
				if (null != tNode.left)
					q.offer(tNode.left);
				if (null != tNode.right)
					q.offer(tNode.right);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 2, 5, 0 };
		SimpleBinaryTree<Integer> sbt = new SimpleBinaryTree<Integer>((a, b) -> (b - a));
		for (int i : arr)
			sbt.add(i);
		System.out.println("Size: " + sbt.size);
		System.out.print("\nDFS : Inorder: ");
		sbt.printInOrder(sbt.root);
		System.out.print("\nDFS : preorder: ");
		sbt.printPreOrder(sbt.root);
		System.out.print("\nDFS : postorder: ");
		sbt.printPostOrder(sbt.root);
		System.out.print("\nBFS : Level order: ");
		sbt.printLevelOrder(sbt.root);

	}

}
