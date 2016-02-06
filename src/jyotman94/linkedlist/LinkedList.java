package jyotman94.linkedlist;

public class LinkedList {

	Node root;

	public LinkedList(int data) {
		root = new Node(data);
	}

	public void add(int data) {
		Node node = new Node(data);
		node.next = root;
		root = node;
	}

	public static void main(String... args) {
		LinkedList ll = new LinkedList(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);

		ll.printList();
		ll.reverseInFixedGroups(2);
		ll.printList();
	}

	// Q7
	// returns root
	public void swapNode(int a, int b) {
		if (root == null)
			return;
		Node prevA = null, currA = root;
		while (currA != null && currA.data != a) {
			prevA = currA;
			currA = currA.next;
		}

		Node prevB = null, currB = root;
		while (currB != null && currB.data != b) {
			prevB = currB;
			currB = currB.next;
		}

		if (currB == null || currA == null)
			return;

		if (prevA != null)
			prevA.next = currB;
		else
			root = currB;

		if (prevB != null)
			prevB.next = currA;
		else
			root = currA;

		Node temp = currA.next;
		currA.next = currB.next;
		currB.next = temp;

		return;
	}

	// Q8
	public void reverseInFixedGroups(int groupSize) {
		Node prev = null, next, curr = root, prevLast = null, currLast;
		boolean firstTime = true;
		while (true) {
			currLast = curr;
			for (int i = 0; i < groupSize; i++) {
				if (curr == null)
					break;
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			if (prevLast != null)
				prevLast.next = prev;
			prevLast = currLast;
			if (firstTime) {
				root = prev;
				firstTime = false;
			}
			if (curr == null)
				break;
			prev = null;
		}
	}

	public void printList() {
		Node temp = root;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(int data) {
		this.data = data;
	}
}