package sharad5.linkedlist;

import sharad5.linkedlist.ReverseLinkedListInGroups.LinkedList;
import sharad5.linkedlist.ReverseLinkedListInGroups.LinkedList.Node;

public class SwapNodes {
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
		
		public void swapNodes(int a, int b){
			Node ptr1=head, ptr2 = head;
			Node prev1=null, prev2 = null;
			Boolean found_a = false, found_b = false;
			while(!found_a || !found_b){
				if(ptr1 == null || ptr2 == null){
					System.out.println("Either or both values not found in the linkedlist");
					return;
				}
				if(ptr1.data != a){
					prev1 = ptr1;
					ptr1 = ptr1.next;
				}
				else
					found_a  = true;
				
				if(ptr2.data != b){
					prev2 = ptr2;
					ptr2 = ptr2.next;
				}
				else found_b = true;
			}
			
			prev1.next = ptr2;
			prev2.next = ptr1;
			Node temp = ptr2.next;
			ptr2.next = ptr1.next;
			ptr1.next = temp;
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
	public static void main(String[] args){
		LinkedList ll=new LinkedList();
		ll.add(0);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.add(8);
		ll.add(9);
		System.out.println("Before: "+ll);
		ll.swapNodes(2, 7);
		System.out.println("After: "+ll);
	}
	
}
