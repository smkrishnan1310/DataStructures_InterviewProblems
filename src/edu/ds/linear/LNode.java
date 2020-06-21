package edu.ds.linear;

/**
 * LNode- List node. Basic Node(doubly) for all list based Data Structures-
 * Doubly LinkedList, Queue, Stack
 */
public class LNode<T> {
	LNode<T> prev;
	LNode<T> next;
	T data;

	LNode(T data) {
		this.data = data;
	}

}
