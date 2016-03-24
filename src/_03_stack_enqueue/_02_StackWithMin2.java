package _03_stack_enqueue;


/**
 * 我们在总栈中额外建了一个栈专门用于存放最小值，这样可以节约空间
 */

public class _02_StackWithMin2 extends Stack{

	Node top;
	Stack stackMin;

    public _02_StackWithMin2(){
        stackMin = new Stack();
    }

	public void push(int val){

        //利用父类已有的方法push方法
		/*if(val < stackMin.peek() || top == null) {
			//在发现比已有的最小值还要小的元素的时候，将其放入栈中
			stackMin.push(val);
			super.push(val);			
		} else if (val >= stackMin.peek()){
			super.push(val);
		}*/

        if (val <= min()) {
            stackMin.push(val);
        }
        super.push(val);
	}

	public int pop(){
        //可以利用父类的pop方法的
		/*if (top == null) {
			return Integer.MAX_VALUE;
		}
        int val = top.val;
		if (val == stackMin.peek()) {
			stackMin.pop();
		}
        top = top.next;
		return val;*/
        int val = super.pop();
        if (val == min()) {
            stackMin.pop();
        }
        return val;
	}

	public int min(){
		if (stackMin.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return stackMin.peek();
		}
	}

	public int peek(){
		return top.val;
	}
}