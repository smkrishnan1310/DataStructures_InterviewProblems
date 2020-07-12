package edu.ds.nonlinear;

/**
 * TNode- tree node. Basic Node representation for trees without height or root
 * data
 */
public class TNode<T> {

	TNode<T> left;
	TNode<T> right;
	T data;

	TNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TNode [left=" + left + ", right=" + right + ", data=" + data + "]";
	}

}
