package sharad5.linkedlist;

import java.util.HashSet;

// Q1 using extra space.
class LinkedList{
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	public void add(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node node = head;
		while(node.next!=null){
			node = node.next;
		}
		node.next = new Node(data);
	}
	public void removeDuplicates(){
		Node head = this.head;
		HashSet<Integer> hash = new HashSet<>();
		Node ptr = head;
		Node prev = null;
		while(ptr != null){
			if(hash.contains(ptr.data))
				prev.next = ptr.next;
			else{
				hash.add(ptr.data);
				prev = ptr;
			}
			ptr = ptr.next;
		}
		//Implemented initially by not keeping record of prev.
		/*while(ptr.next != null){
			while(ptr.next != null && hash.contains(ptr.next.data)){
				ptr.next = ptr.next.next;
			}
			if(ptr.next == null)
				break;
			hash.add(ptr.next.data);
			ptr = ptr.next;
		}*/
	}
	public String toString(){
		Node node = head;
		StringBuffer s = new StringBuffer("");
		while(node != null){
			s.append(node.data + (node.next != null ? " -> " : ""));
			node = node.next;
		}
		return s.toString();
	}
}

public class RemoveDuplicates {
	public static void main(String[] args){
		LinkedList ll=new LinkedList();
		ll.add(5);
		ll.add(1);
		ll.add(0);
		ll.add(6);
		ll.add(5);
		ll.add(4);
		ll.add(2);
		ll.add(1);
		ll.add(0);
		ll.add(2);
		System.out.println("Before: "+ll);
		ll.removeDuplicates();
		System.out.println("After: "+ll);
	}
}
