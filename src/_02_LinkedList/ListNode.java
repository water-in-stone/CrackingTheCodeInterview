package _02_LinkedList;

public class ListNode {
	ListNode next = null;
	int val;

	public ListNode (int val) {
		this.val = val;
	}

	public void appendTrail (int d){
		ListNode end = new ListNode(d);
		ListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void appendNodeToTrail(ListNode a){
        ListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = a;
    }

	public ListNode insert(int val){
		ListNode next = this.next;
		this.next = new ListNode(val);
		this.next.next = next;
		return this;
	}
}