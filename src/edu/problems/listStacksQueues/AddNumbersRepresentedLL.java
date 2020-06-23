package edu.problems.listStacksQueues;

/**
 * Problem: Add two numbers represented in the form of singly LinkedList as like
 * below
 * 
 * a = 1234 	List l1 = 1->2->3->4->null 
 * b = 970 		List l2 = 9->7->0->null 
 * c = a+b=2204 List ans = 2->2->0->4->null
 * 
 */
//SLNode = Singly ListNode
class SLNode {
	int data;
	SLNode next;

	SLNode(int data) {
		this.data = data;
	}
}

public class AddNumbersRepresentedLL {

	// Iterative solution to add numbers
	public SLNode add(SLNode l1, SLNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		l1 = reverse(l1);
		l2 = reverse(l2);

		int carry = 0;
		int tsum = 0;
		SLNode head = null;

		while (l1 != null && l2 != null) {
			tsum = carry + l1.data + l2.data;
			head = addFront(head, tsum % 10);
			carry = tsum / 10;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			tsum = carry + l1.data;
			head = addFront(head, tsum % 10);
			carry = tsum / 10;
			l1 = l1.next;
		}
		while (l2 != null) {
			tsum = carry + l2.data;
			head = addFront(head, tsum % 10);
			carry = tsum / 10;
			l2 = l2.next;
		}
		if (carry > 0)
			head = addFront(head, carry);
		return head;
	}

	public SLNode addFront(SLNode head, int data) {
		SLNode node = new SLNode(data);
		if (null != head)
			node.next = head;
		return node;
	}

	// Recursive function to reverse SLL
	public SLNode reverse(SLNode head) {
		if (null == head)
			return null;
		return reverse(head, null);
	}

	public SLNode reverse(SLNode head, SLNode prev) {
		if (head.next != null) {
			SLNode nxt = head.next;
			head.next = prev;
			head = reverse(nxt, head);
		} else
			head.next = prev;
		return head;
	}

	public void print(SLNode head) {
		while (null != head) {
			System.out.print(head.data + ", ");
			head = head.next;
		}
		System.out.println("\n----");
	}

	public static void main(String[] args) {
		AddNumbersRepresentedLL obj = new AddNumbersRepresentedLL();
		
		//Num 1 = 1234
		SLNode num1 = new SLNode(1);
		num1.next = new SLNode(2);
		num1.next.next = new SLNode(3);
		num1.next.next.next = new SLNode(4);
		
		//Num2 = 970
		SLNode num2 = new SLNode(9);
		num2.next = new SLNode(7);
		num2.next.next = new SLNode(0);
		//Inputs
		obj.print(num1);
		obj.print(num2);
		
		//Result
		SLNode ans = obj.add(num1, num2);
		obj.print(ans);

	}

}