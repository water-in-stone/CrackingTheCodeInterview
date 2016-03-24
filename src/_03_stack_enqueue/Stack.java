package _03_stack_enqueue;

/**
 * Created by Young on 2016/3/24.
 * wang645788@gmail.com
 */
class Stack {
    Node top;//维护一个栈顶元素即可,是一个指向栈底的链表头

    //push的元素的类型不定
    public void push(int val){
    	Node t = new Node<>(val);
    	t.next = top;
    	top = t;
    }

    public int pop(){
    	if (top == null) {
    		return Integer.MAX_VALUE;
    	} else {
            int val = top.val;
    		top = top.next;
    		return val;
    	}
    }

    public int peek(){
    	return top.val;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
