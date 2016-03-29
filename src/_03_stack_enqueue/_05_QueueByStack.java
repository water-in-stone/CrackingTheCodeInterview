package _03_stack_enqueue;

/**
 * Created by Young on 2016/3/28.
 * wang645788@gmail.com
 */

/**
 * 思路：创建两个栈，从栈顶从下看，其中一个栈的元素时正序的（用于pop），
 * 另外一个栈的元素时逆序的（用于push），且当正序栈的元素为空时，
 * 就把逆序栈中的所有元素全部放到正序栈中
 */
public class _05_QueueByStack {

	Stack<Integer> stack1 = new Stack<>();//正序栈，用于pop操作
	Stack<Integer> stack2 = new Stack<>();//逆序栈，用于push操作

    public void push(int node) {
        stack2.push(node);
    }
    
    public int pop() {
    	if (stack1.isEmpty()) {
    		int nodeVal;
    		while(!stack2.isEmpty()){
    			nodeVal = stack2.pop();
    			stack1.push(nodeVal);
    		}
    		return  stack1.pop();
    	} else {
    		return  stack1.pop();
    	}
    }
}
