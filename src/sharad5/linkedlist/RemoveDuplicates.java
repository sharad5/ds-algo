package sharad5.linkedlist;

import java.util.HashSet;

import sharad5.linkedlist.LinkedList.Node;


class LinkedList1{
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
		Node current = head, ptr;
		while(current!=null){
			ptr = current.next;
			int current_data = current.data;
			Node prev = current;
			while(ptr != null){
				if(ptr.data == current_data){
					prev.next = ptr.next;
				}
				else{
					prev = prev.next;
				}
				ptr = ptr.next;
			}
			current = current.next;
		}
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
		LinkedList1 ll=new LinkedList1();
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
