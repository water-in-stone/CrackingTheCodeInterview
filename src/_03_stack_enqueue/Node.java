package _03_stack_enqueue;

public class Node<Object> {
	//这里的节点只有next，构建队列和栈时要考虑到这一点
	Node next = null;
	int val;

	public Node(int val) {
		this.val = val;
	}

	public void appendTrail (int d){
		Node end = new Node<>(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void appendNodeToTrail(Node a){
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = a;
    }

	public Node insert(int val){
		Node next = this.next;
		this.next = new Node<>(val);
		this.next.next = next;
		return this;
	}
}