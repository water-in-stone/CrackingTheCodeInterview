package _02_LinkedList;

/**
 * Created by Young on 2016/3/16.
 * wang645788@gmail.com
 */
public class _3_Delete {

	/**
	 * remove one node
	 * @param  pNode [ListNode]
	 * @return       [false when pNode is the last ListNode]
	 */
	public static boolean removeNode(ListNode pNode) {
        ListNode next = pNode.next;
        pNode = next;
        if (pNode == null) {
        	return false;
        } else {
        	return true;
        }
    }

    public static void main(String[] args) {
    	ListNode first = new ListNode(1);
    	ListNode second = new ListNode(2);
    	first.next = second;
    	removeNode(second);
    }
}
