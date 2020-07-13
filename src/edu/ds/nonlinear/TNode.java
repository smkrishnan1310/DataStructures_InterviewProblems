package edu.ds.nonlinear;

/**
 * TNode- tree node. Basic Node representation for trees without height or root
 * data
 * 
 * Please note variable left, right and data should not be public and needs to
 * be private and have to provide getter setter. Here just for demo i didn't
 * made it
 */
public class TNode<T> {

	public TNode<T> left;
	public TNode<T> right;
	public T data;

	public TNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TNode [left=" + left + ", right=" + right + ", data=" + data + "]";
	}

}
