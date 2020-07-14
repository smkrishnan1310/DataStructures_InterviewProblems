package edu.problems.listStacksQueues;

/**
 * 
 * Program to find given singly linked list (SLL) is Palindrome or not? with
 * time complexity O(n) and with no extra space or with constant space
 * 
 * Each character of the string/ digits of a number is represented as single node in SLL
 * 
 */
public class LinkedListPalindrome {

	public boolean isPalindrome(SListNode node) {
		if (null != node) {
			SListNode ptr1 = node;
			SListNode ptr2 = node;
			SListNode prev = null;
			SListNode temp = node;

			while (null != ptr2.next && null != ptr2.next.next) {
				temp = ptr1;
				ptr1 = ptr1.next;
				ptr2 = ptr2.next.next;
				temp.next = prev;
				prev = temp;
			}

			if (null == ptr2.next) {
				ptr2 = ptr1.next;
				ptr1 = temp;
			} else {
				ptr2 = ptr1.next;
				ptr1.next = temp;
			}

			return isPalindrome(ptr1, ptr2);
		}
		return false;
	}

	public boolean isPalindrome(SListNode node1, SListNode node2) {
		while (null != node1 && null != node2) {
			if (node1.data != node2.data)
				return false;
			node1 = node1.next;
			node2 = node2.next;
		}
		return true;
	}

	public void printSListNode(SListNode head) {
		if (null != head) {
			while (null != head) {
				System.out.print(head.data + ", ");
				head = head.next;
			}
		}
	}

	// Driver Method
	public static void main(String[] args) {
		String s = "malayalam";
		SListNode head = new SListNode(s.charAt(0));
		SListNode temp = head;
		for (int i = 1; i < s.length(); i++) {
			temp.next = new SListNode(s.charAt(i));
			temp = temp.next;
		}

		LinkedListPalindrome pal = new LinkedListPalindrome();
		pal.printSListNode(head);
		System.out.println(" = " + pal.isPalindrome(head));
	}

}

class SListNode {
	SListNode next;
	Character data;

	SListNode(Character data) {
		this.data = data;
	}
}