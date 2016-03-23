package _02_LinkedList;
import java.util.*;

/**
 * Created by Young on 2016/3/23.
 * wang645788@gmail.com
 */
public class _6_loop {
    
    /**
     * 每访问一个节点时，查看节点的地址是否存在在ArrayList中，若存在说明存在环路，
     * 则返回此节点的地址，否则的话将新节点的值存入ArrayList中
     * @param  a [链表头节点]
     * @return   [环路的起始节点]
     */
    public static ListNode loopExisted(ListNode a){
    	ArrayList<ListNode> listNode = new ArrayList<>();
    	int i;
    	while (a.next != null) {
    		for (i = 0; i < listNode.size(); i++) {
    			if(listNode.get(i) == a){
    				return a;
    			}
    		}
    		listNode.add(a);
    		a = a.next;
    	}
    	return null;//即使指定了返回值为ListNode，返回null也是可以的
    }

    /**
     * 标准答案使用了快慢指针的技巧，按图走了之后确实有着意想不到的效果，
     * 两个指针的位置暗含规律，这个技巧不错！
     * @param  head [链表头节点]
     * @return   [环路的起始节点]
     */
    public static ListNode loopExisted2(ListNode head){
    	ListNode fast = head;
    	ListNode slow = head;
    	//让快慢指针跑起来直到相撞为止
    	while(fast != null && fast.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow){
    			break;
    		}
    	}
    	//若没有碰撞且没有环路，则直接返回null
    	if (fast == null || fast.next == null) {
    		return null;
    	}

    	//将slow指向头部，fast则处于碰撞点
    	//将两人的步伐同时调整为每次走一步
    	//再次相遇的地方就是环路的起点
    	slow = head;
    	while(slow != fast){
    		slow = slow.next;
    		fast = fast.next;
    	}
    	//返回环路的起点
    	return fast;

    }
    
    public static void main(String[] args) {
		ListNode loopNode = new ListNode(5);
        ListNode a = new ListNode(2);
        a.appendTrail(3);
        a.appendNodeToTrail(loopNode);
        a.appendTrail(7);
        a.appendTrail(9);
        a.appendNodeToTrail(loopNode);
        loopExisted2(a);
    }
}
