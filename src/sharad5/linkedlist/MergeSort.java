package sharad5.linkedlist;

import sharad5.linkedlist.PartitionALinkedList.LinkedList;

public class MergeSort {
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
		
		public void msort(){
			head = mergeSort(head);
			
		}
		/***
		 * partitions the LinkedList into two lists.
		 * @return reference to the mid of the LinkedList.
		 */
		private Node splitInTwo(Node head){
			Node slow = head,fast = head.next;
			while(fast !=null){
				//System.out.println(slow+" "+fast);
				fast = fast.next;
				if(fast!=null){
					fast = fast.next;
					slow = slow.next;
				}
			}
			
			Node mid = slow.next;
			slow.next = null;
			return mid;
		}
		/***
		 * Recursive mergeSort function
		 * @param head
		 */
		private Node mergeSort(Node head){
			if(head == null || head.next ==null)
				return head;
			Node mid = splitInTwo(head);
			head = mergeSort(head);
			mid = mergeSort(mid);
			
			head = mergeRecursive(head, mid);
			return head;
		}
		
		/***
		 * merge two sorted linkedlists.
		 * 
		 * @param head
		 * @param mid
		 * @return head of the LinkedList
		 */
		private Node mergeRecursive(Node head, Node mid){
			if(mid == null)
				return head;
			if(head == null)
				return mid;
			Node result;
			if(head.data <= mid.data){
				result = head;
				result.next = mergeRecursive(head.next, mid);
			}
			else{
				result = mid;
				result.next = mergeRecursive(head, mid.next);
			}
			return result;
		}
	}
	public static void main(String[] args){
		LinkedList ll=new LinkedList();
		ll.add(1);
		ll.add(4);
		ll.add(5);
		ll.add(2);
		ll.add(3);
		ll.add(6);
		System.out.println("unsorted: "+ll);
		ll.msort();;
		System.out.println("sorted: "+ll);
	}
}
