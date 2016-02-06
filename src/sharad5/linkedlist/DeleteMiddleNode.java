package sharad5.linkedlist;


/* Q2. Implement an algorithm to delete a node in the middle of a singly linked list, given access only to that node. 
 * Example - Before => a->b->c->d->e , After => a->b->d->e */
class Node{
	int data;
	Node next;
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
public class DeleteMiddleNode {
	
	public static void deleteMidNode(Node mid){
		if(mid.next ==  null){
			System.out.println("Not a middle Node.");
			return;
		}
		mid.data = mid.next.data;
		mid.next = mid.next.next;
	}
	public static String printLL(Node head){
		Node node = head;
		StringBuffer s = new StringBuffer("");
		while(node != null){
			s.append(node.data + (node.next != null ? " -> " : ""));
			node = node.next;
		}
		return s.toString();
	}
	
	public static void main(String[] args){
		
		Node node[] = new Node[11];
		Node next = null;
		for(int i= 10;i>=0;i--){
			node[i] = new Node(i,next);
			next = node[i];
		}
		System.out.println(printLL(node[0]));
		deleteMidNode(node[6]);
		System.out.println(printLL(node[0]));
	}
}
