package _02_LinkedList;

class ListNode {
	ListNode next = null;
	int data;

	public ListNode (int data) {
		this.data = data;
	}

	public void appendTrail (int d){
		ListNode end = new ListNode(d);
		ListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}