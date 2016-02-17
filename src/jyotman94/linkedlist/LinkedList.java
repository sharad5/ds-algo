package jyotman94.linkedlist;

import java.util.*;

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
		LinkedList ll = new LinkedList(4);
		ll.add(5);
		ll.add(3);
		ll.add(2);
		ll.add(7);
		ll.add(8);
		ll.add(1);

		ll.printList();
		ll.partition(ll.root.next.next.next.next);
		ll.printList();
	}

	// Q1
	//Order changes
	//Complexity - nlogn
	public void removeDuplicatesWithoutBuffer() {
		root = MergeSort(root);
		Node temp = root;
		while(temp.next != null){
			if(temp.data == temp.next.data){
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
	}
	
	// Q1
	public void removeDuplicates(){
		Node temp = root, temp2, prev;
		while(temp.next != null){
			temp2 = temp.next;
			prev = temp;
			while(temp2 != null){
				if(temp.data == temp2.data){
					prev.next = temp2.next;
				}
			}
			prev = temp;
			temp = temp.next;
		}
	}

	// Q2
	public void deleteMiddleAccessNode(Node middle) {
		middle.data = middle.next.data;
		middle.next = middle.next.next;
	}

	// Q3
	public static LinkedList addNumberedLists(Node head1, Node head2) {
		Node list1 = head1, list2 = head2;
		int ones, carry;
		int sum = head1.data + head2.data;
		if (sum >= 10) {
			ones = Integer.parseInt(String.valueOf(sum).substring(1, 2));
			carry = Integer.parseInt(String.valueOf(sum).substring(0, 1));
		} else {
			ones = sum;
			carry = 0;
		}
		LinkedList ans = new LinkedList(ones);
		list1 = list1.next;
		list2 = list2.next;

		while (list1 != null && list2 != null) {
			sum = list1.data + list2.data + carry;
			if (sum >= 10) {
				ones = Integer.parseInt(String.valueOf(sum).substring(1, 2));
				carry = Integer.parseInt(String.valueOf(sum).substring(0, 1));
			} else {
				ones = sum;
				carry = 0;
			}
			ans.add(ones);
			list1 = list1.next;
			list2 = list2.next;
		}

		while (list1 != null) {
			sum = list1.data + carry;
			if (sum >= 10) {
				ones = Integer.parseInt(String.valueOf(sum).substring(1, 2));
				carry = Integer.parseInt(String.valueOf(sum).substring(0, 1));
			} else {
				ones = sum;
				carry = 0;
			}
			ans.add(ones);
			list1 = list1.next;
		}

		while (list2 != null) {
			sum = list2.data + carry;
			if (sum >= 10) {
				ones = Integer.parseInt(String.valueOf(sum).substring(1, 2));
				carry = Integer.parseInt(String.valueOf(sum).substring(0, 1));
			} else {
				ones = sum;
				carry = 0;
			}
			ans.add(ones);
			list2 = list2.next;
		}

		if (carry != 0)
			ans.add(carry);

		ans.reverseList();
		return ans;
	}

	// Q4
	public static LinkedList addNumberedList2(LinkedList list1, LinkedList list2) {
		list1.reverseList();
		list2.reverseList();
		LinkedList ans = addNumberedLists(list1.root, list2.root);
		list1.reverseList();
		list2.reverseList();
		ans.reverseList();
		return ans;
	}
	
	//Q5
	public void partition(Node x){
		Node temp = root;
		LinkedList small = new LinkedList(0);
		LinkedList big = new LinkedList(0);
		while(temp != null){
			if(temp.data > x.data){
				big.add(temp.data);
			}
			else if(temp.data < x.data)
				small.add(temp.data);
			temp = temp.next;
		}
		
		temp = small.root;
		root = temp;
		while(temp.next.next != null)
			temp = temp.next;
		temp.next = x;
		x.next = big.root;
		temp = big.root;
		while(temp.next.next != null)
			temp = temp.next;
		temp.next = null;
	}

	// Q6
	public boolean isPalindrome(){
		Node temp = root;
		int length = this.length();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < length / 2; i++){
			stack.push(temp.data);
			temp = temp.next;
		}
		
		//For odd number of nodes
		if(length % 2 == 1)
			temp = temp.next;
		
		for(int i = 0; i < length / 2; i++){
			if(stack.pop() != temp.data)
				return false;
			temp = temp.next;
		}
		return true;
	}

	// Q7
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
	
	//Q9
	public Node MergeSort(Node head){
		Node a, b;
		if(head == null || head.next == null)
			return head;
		
		ArrayList<Node> split = frontBackSplit(head);
		a = split.get(0);
		b = split.get(1);
			
		a = MergeSort(a);
		b = MergeSort(b);
		
		head = sortedMerge(a, b);
		return head;
	}
	
	private Node sortedMerge(Node a, Node b){
		Node result = null;
		if(a == null)
			return b;
		else if(b == null)
			return a;
		
		if(a.data <= b.data){
			result = a;
			result.next = sortedMerge(a.next, b);
		}
		else{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}
	
	/* UTILITY FUNCTIONS */
	/* Split the nodes of the given list into front and back halves,
	     and return the two lists using the reference parameters.
	     If the length is odd, the extra node should go in the front list.
	     Uses the fast/slow pointer strategy.  */
	private ArrayList<Node> frontBackSplit(Node source){
		Node fast, slow, back = null;
		
		if(source != null && source.next != null){
			slow = source;
			fast = source.next;
			while(fast != null){
				fast = fast.next;
				if(fast != null){
					slow = slow.next;
					fast = fast.next;
				}
			}
			
			//'slow' is before the midpoint in the list, so split it in two at that point. 
			back = slow.next;
			slow.next = null;
		}
		ArrayList<Node> nodes = new ArrayList<>();
		nodes.add(source);
		nodes.add(back);
		return nodes;
	}

	public void reverseList() {
		Node prev = null, curr = root, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		root = prev;
	}

	public int length() {
		int length = 0;
		Node temp = root;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
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