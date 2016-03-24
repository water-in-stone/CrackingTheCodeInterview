package _03_stack_enqueue;

/**
 * Created by Young on 2016/3/24.
 * wang645788@gmail.com
 */
public class Queue {
    Node first;
    Node last;

    public void enqueue(int val){
    	//注意到队列是FIFO的
		/*Node one = new Node<>(obj);
    	if (first == null && last == null) {
    		first = one;
    		last = one;
    	} else {
			one.last = last;
			last = one;    		
    	}*/
    	//节点只有next后继，这样在构造时可以使得时间复杂度为O(1)
    	Node one = new Node<>(val);
    	if (first == null) {
    		first = one;
    		last = one;
    	} else {
    		last.next = one;
    		last = one;
    	}
    }

    public int dequeue(){
    	if (first == null) {
    		return Integer.MAX_VALUE;
    	}
        int value = first.val;
    	first = first.next;
    	return value;
    }
}
