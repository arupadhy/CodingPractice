package list;

public class RevereListRecursively {
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		printList(head);
		System.out.println("*****************************************");
		System.out.println("After reversing list");
		printList(reverseList(head));
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static Node reverseList(Node head) {
		
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		Node first = head;
		Node rest = reverseList(first.next);
		
		first.next.next = first;
		first.next = null;
		return rest;
	}
	
	
	
	private static class Node {
		Node next;
		int data;
		public Node(int d) {
			this.next = null;
			this.data = d;
		}
	}

}
