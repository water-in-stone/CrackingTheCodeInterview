package _03_stack_enqueue;


/**
 * 想象一个栈仅有一个元素的时候，此时的最小值就是它自己，而
 * 所谓的最小值是相对于当前栈的状态来说的，所以我们每push一个元素，都判断一次最小值（与栈顶元素比较即可）
 * 那么我们每一次获取最小值的时候，只需要问栈顶元素即可
 * @param <Integer>
 * @optimise 可能存在浪费空间的情况，万一最小值就是第一个元素的时候，所以我们可以改进，详见_02_StackWithMin2.java
 */
class Node2<Integer> {

	Node2 next = null;
	int min;
	int val;
	
	public Node2(int val, int min) {
		this.val = val;
		this.min = min;
	}
}

public class _02_StackWithMin {
	Node2 top;

	public void push(int value){
        Node2 t;
		if (top == null) {
			 t = new Node2<>(value,value);
		} else {
			 t = new Node2<>(value, Math.min(value, top.val));
		}
		t.next = top;
		top = t;	
	}

	public int pop(){
		if (top == null) {
			return Integer.MAX_VALUE;
		} else {
			int obj = top.val;
			top = top.next;
			return obj;
		}
	}

	public int min(){
		if (top == null) {
			return Integer.MAX_VALUE;
		} else {
			return top.min;
		}
	}

	public int peek(){
		return top.val;
	}
}