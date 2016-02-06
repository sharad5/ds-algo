package sharad5.linkedlist;

import sharad5.linkedlist.PalindromeCheck.LinkedList;

public class AddNumbers {
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
		class Result{
			Node node;
			boolean isPal;
			public Result(Node node, boolean isPal) {
				this.node = node;
				this.isPal = isPal;
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
		
		public LinkedList addReverseLinkedLists(LinkedList list){
			Node ptr1 = this.head;
			Node ptr2 = list.head;
			int carry = 0;
			int sum = 0;
			LinkedList res = new LinkedList();
			while(ptr1 != null || ptr2 != null){
				sum = ((ptr1 != null)? ptr1.data : 0) + ((ptr2 != null)? ptr2.data : 0) + carry;
				res.add(sum%10);
				carry = sum /10;
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			if(carry != 0)
				res.add(1);
			return res;
		}
		
		public static int addLinkedListsRecurse(Node ptr1,Node ptr2, LinkedList result){
			if(ptr1.next == null && ptr2.next == null){
				int sum = ptr1.data + ptr2.data;
				result.addInFront(sum %10);
				return sum/10;
			}
			int carry = addLinkedListsRecurse(ptr1.next, ptr2.next, result);
			int sum = ptr1.data + ptr2.data +carry;
			result.addInFront(sum%10);
			return sum/10;
		}
		
		public LinkedList addLinkedLists( LinkedList list2){
			LinkedList list1 = this;
			LinkedList result = new LinkedList();
			int len1 = list1.length();
			int len2 = list2.length();
			if(len2 > len1){
				for(int i=0; i< len2-len1;i++){
					list1.addInFront(0);
				}
			}
			else if(len1 > len2){
				for(int i=0; i< len1-len2;i++){
					list2.addInFront(0);
				}
			}
			int carry = addLinkedListsRecurse(list1.head, list2.head, result);
			if(carry != 0){
				result.addInFront(carry);
			}
			return result;
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
		LinkedList a=new LinkedList();
		a.add(1);
		a.add(9);
		a.add(5);
		a.add(7);
		LinkedList b=new LinkedList();
		b.add(1);
		b.add(9);
		b.add(2);
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		System.out.println("Result: "+a.addLinkedLists(b));
	}
	
}
