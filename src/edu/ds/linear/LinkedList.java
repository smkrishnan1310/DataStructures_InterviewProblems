package edu.ds.linear;

public class LinkedList<T> {

	protected LNode<T> head = null;
	protected LNode<T> tail = null;
	protected int size = 0;

	public void add(T data) {
		LNode<T> n = new LNode<>(data);
		if (head == null)
			head = tail = n;
		else {
			n.prev = tail;
			tail = tail.next = n;
		}
		size++;
	}

	public void remove(int index) {
		if (size <= index)
			return;
		else {
			LNode<T> tmp = head;
			for (int i = 0; i < index; i++)
				tmp = tmp.next;
			if (tmp == head) {
				head = tmp.next;
				head.prev = null;
			} else if (tmp == tail) {
				tail = tmp.prev;
				tail.next = null;
			} else {
				tmp.prev.next = tmp.next;
				tmp.next.prev = tmp.prev;
			}
			clear(tmp);
			size--;
		}
	}

	private void clear(LNode<T> tmp) {
		tmp.next = null;
		tmp.prev = null;
		tmp.data = null;
	}

	private static void print(LinkedList<Integer> ll) {
		LNode<Integer> tmp = ll.head;
		while (null != tmp) {
			System.out.print(tmp.data + ", ");
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, -4 };
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int v : arr)
			ll.add(v);
		System.out.println(ll.size);
		print(ll);
		ll.remove(3);
		ll.remove(1);
		System.out.println("\n" + ll.size);
		print(ll);
	}

}
