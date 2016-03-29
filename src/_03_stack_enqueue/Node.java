package _03_stack_enqueue;

public class Node<Object> {
	//这里的节点只有next，构建队列和栈时要考虑到这一点
	Node next = null;
	int val;
    int time;//时间戳，记录

	public Node(int val) {
		this.val = val;
		this.time = 0;
	}

	public Node(int val, int time){
        this.val = val;
        this.time = time;
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

    public int getTime(){
        return this.time;
    }
}