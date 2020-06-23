package edu.problems.listStacksQueues;

//SLL= Singly List Node
class SLLNode {

	int data;
	SLLNode next;

	SLLNode(int data) {
		this.data = data;
	}
}

/**
 * Problem: Basics: Reversing Singly Linked List recursively and iteratively
 */
public class ReverseSingleLinkedList {

	public static SLLNode reverseIteratively(SLLNode head) {
		if (null == head)
			return head;

		SLLNode prev = null;
		while (head.next != null) {
			SLLNode tmp = head;
			head = head.next;
			tmp.next = prev;
			prev = tmp;
		}
		head.next = prev;
		return head;
	}

	public static SLLNode reverseRecursively(SLLNode head, SLLNode prev) {
		if (head == null)
			return head;
		if (head.next != null) {
			SLLNode nxt = head.next;
			head.next = prev;
			head = reverseRecursively(nxt, head);
		} else
			head.next = prev;
		return head;
	}

	public static void print(SLLNode head) {
		while (null != head) {
			System.out.print(head.data + ", ");
			head = head.next;
		}
		System.out.println("\n------");
	}

	public static void main(String[] args) {
		SLLNode head = new SLLNode(5);
		head.next = new SLLNode(4);
		head.next.next = new SLLNode(3);
		head.next.next.next = new SLLNode(2);
		head.next.next.next.next = new SLLNode(1);
		head.next.next.next.next.next = new SLLNode(0);

		print(head);
		head = reverseRecursively(head, null);
		System.out.println("Reverse recursive");
		print(head);

		head = reverseIteratively(head);
		System.out.println("Reverse iteratively");
		print(head);

	}

}