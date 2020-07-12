package edu.ds.linear;

public class Queue<T> {

	LNode<T> head = null;
	LNode<T> tail = null;
	int size;

	public void offer(T data) {
		LNode<T> n = new LNode<>(data);
		if (null == head)
			head = tail = n;
		else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		size++;
	}

	public T poll() {
		if (null == head)
			return null;

		LNode<T> tmp = head;
		T data = tmp.data;
		head = head.next;
		if (tail == tmp)
			tail = null;
		else
			head.prev = null;

		tmp.data = null;
		tmp.next = null;
		size--;
		return data;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public static void main(String[] args) {

		int arr[] = { 2, 3, 2, 0, -9, 89 };
		Queue<Integer> q = new Queue<>();
		for (int i : arr)
			q.offer(i);

		System.out.println("Size: " + q.size);
		while (!q.isEmpty())
			System.out.print(q.poll() + ", ");
		
		System.out.println("\nSize: " + q.size);
	}

}
