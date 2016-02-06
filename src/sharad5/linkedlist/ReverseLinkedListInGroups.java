package sharad5.linkedlist;


//Q8. Reverse a Linked List in groups of given size.
public class ReverseLinkedListInGroups {
	
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
		/***
		 * 
		 * @param head
		 * @param n
		 * @return an array of size three [new head, new tail, next head]
		 */
		public static Node[] reverse(Node head, int n){
			Node curr = head, prev = null, next = null;
			
			while(n-->0 && curr!=null){
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
			}
			Node[] res = new Node[3];
			res[0] = prev;
			res[1] = head;
			res[2] = curr;
			return res;
		}
		
		public void reverseInGroup(int n){
			Node node = head, prev_tail= null;
			while(node != null){
				Node[] res = reverse(node, n);
				Node new_head = res[0];
				Node new_tail = res[1];
				node = res[2];
				if(prev_tail == null){
					head = new_head;
				}
				else{
					prev_tail.next = new_head;
				}
				prev_tail = new_tail;
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
		ll.reverseInGroup(3);
		System.out.println("After: "+ll);
	}
}
