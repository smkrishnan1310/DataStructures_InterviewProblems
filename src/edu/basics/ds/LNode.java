package edu.basics.ds;

public class LNode<T> {
	LNode<T> prev;
	LNode<T> next;
	T data;

	LNode(T data) {
		this.data = data;
	}

}
