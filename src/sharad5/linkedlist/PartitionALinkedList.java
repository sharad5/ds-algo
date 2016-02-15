package sharad5.linkedlist;

import sharad5.linkedlist.SwapNodes.LinkedList;

public class PartitionALinkedList {
	static class LinkedList{
		private Node head;
		class Node{
			int data;
			Node next;
			
			public Node(int data) {
				this.data = data;
				this.next = null;
			}
			public String toString(){
				return String.valueOf(this.data);
			}
		}
		
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
		public int length(){
			Node node = head;
			int len = 0;
			while(node != null){
				node = node.next;
				len++;
			}
			return len;
		}
		public void addInFront(int data){
			if(head == null){
				head = new Node(data);
				return;
			}
			Node node = new Node(data);
			node.next = head;
			head = node;
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
		
		public void partitionAroundX(int x){
			LinkedList list = new LinkedList();
			Node node = this.head;
			while(node != null){
				if(node.data < x){
					list.addInFront(node.data);
				}
				else{
					list.add(node.data);
				}
				node = node.next;
			}
			head = list.head;
		}
		public static void main(String[] args){
			LinkedList ll=new LinkedList();
			ll.add(5);
			ll.add(2);
			ll.add(3);
			ll.add(6);
			ll.add(1);
			ll.add(4);
			System.out.println("Before: "+ll);
			ll.partitionAroundX(2);
			System.out.println("After: "+ll);
		}
	}
}
