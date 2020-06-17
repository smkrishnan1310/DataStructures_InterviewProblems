package edu.basics.ds;

public class Stack<T> {

	LNode<T> top;
	int size;

	public void push(T data) {
		LNode<T> n = new LNode<>(data);
		if (null == top)
			top = n;
		else {
			n.prev = top;
			top.next = n;
			top = n;
		}
		size++;
	}

	public T peek() {
		if (null == top)
			return null;
		return top.data;
	}

	public T pop() {
		if (null == top)
			return null;

		LNode<T> tmp = top;
		T data = tmp.data;
		top = tmp.prev;

		tmp.data = null;
		tmp.prev = null;
		size--;
		return data;
	}

	public boolean isEmpty() {
		return (null == top);
	}

	public static void main(String args[]) {
		int arr[] = { 1, 22, 3, 4, 15, 6, 10 };
		Stack<Integer> st = new Stack<>();
		for (int i : arr)
			st.push(i);

		System.out.println("Size: " + st.size);
		System.out.println("Peek: " + st.peek());
		while (!st.isEmpty())
			System.out.print(st.pop() + ", ");

		System.out.println("\nSize: " + st.size);
	}

}
