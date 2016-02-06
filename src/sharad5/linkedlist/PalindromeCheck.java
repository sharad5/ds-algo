package sharad5.linkedlist;

import sharad5.linkedlist.SwapNodes.LinkedList;
import sharad5.linkedlist.SwapNodes.LinkedList.Node;

public class PalindromeCheck {
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
		
		
		public boolean isPalindrome(){
			int len = 0;
			Node node = head;
			while(node!=null){
				len ++;
				node = node.next;
			}
			return palindromeRecurse(head, len).isPal;
		}
		public Result palindromeRecurse(Node head, int len){
			if(head == null){
				return new Result(null, true); 
			}
			if(len == 1){
				return new Result(head.next, true);
			}
			if(len == 2){
				return new Result(head.next.next, head.data == head.next.data);
			}
			int a = head.data;
			Result res = palindromeRecurse(head.next, len-2);
			return new Result(res.node.next, (res.isPal && (a==res.node.data)));
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
		ll.add(1);
		ll.add(0);
		System.out.println("LL: "+ll);
		System.out.println("isPalindrome: "+ll.isPalindrome());
	}
}
