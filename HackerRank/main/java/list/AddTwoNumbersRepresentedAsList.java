package list;

public class AddTwoNumbersRepresentedAsList {
	
	private static class List {
		
		Node head;
		Node tail;
		
		public Node append(int x) {
			if(head == null) {
				head = new Node(x);
				tail = head;
			}else {
				tail.next = new Node(x);
				tail = tail.next;
			}
			return head;
		}
		public Node prepend(int d) {
			if(head == null) {
				head = new Node(d);
			}else {
				Node newNode = new Node(d);
				newNode.next = head;
				head = newNode;
			}
			return head;
		}
	}
	private static class Node {
		Node next;
		int data;
		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	public static Node createList(int[] input) {
		
		List list = new List();
		for( int x: input) {
			list.append(x);
		}
		return list.head;
	}
	
	public static Node createList(int number) {
		List list = new List();
		while(number !=0) {
			int l = number % 10;
			list.prepend(l);
			number = number/10;
		}
		return list.head;
	}

	public static void printList(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
//		int no = 12345;
		int[]no = new int[]{1,2,3,4,5,6,7};
		
		
		
		printList(createList(no));
	}
}
