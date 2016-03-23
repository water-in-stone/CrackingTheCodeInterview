package _02_LinkedList;

import java.util.*;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class _5_plusAB {
	/**
	 * 从个位数开始一位位计算，并判断是否产生了进位
	 * @param  a [个位数排在首位的链表头]
	 * @param  b [个位数排在首位的链表头]
	 * @return   [相加后的结果，依然是个位在首部]
	 */
    public static ListNode plusAB(ListNode a, ListNode b) {
    	if (a == null && b == null) {
    		System.exit(0);
    	}
    	//若a/b中有一个是null，则不做计算并直接返回
        if (a == null || b == null) {
            return a == null ? b : a;
        }
    	//存放结果
    	ListNode next = new ListNode(0);
    	ListNode result = next;
    	int n1 = 0;
    	int n2 = 0; 
    	int temp = 0;//在某一位上计算得到的和
    	while(a != null || b != null){
    		n1 = (a == null) ? 0 : a.val;
    		n2 = (b == null) ? 0 : b.val;
    		temp = next.val + n1 + n2;
    		next.val = temp % 10;
    		a = (a == null) ? null : a.next;
    		b = (b == null) ? null : b.next;
    		//三种情况：a还有位数未加/b还有位数未加/产生了进位
    		if (a != null || b!= null || (temp / 10) > 0) {
	    		next.next = new ListNode(temp / 10);
    		}
    		next = next.next;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	ListNode a = new ListNode(7);
    	a.appendTrail(1);
    	a.appendTrail(6);
    	ListNode b = new ListNode(3);
    	b.appendTrail(9);
    	b.appendTrail(2);
    	plusAB(a, b);
    }
}