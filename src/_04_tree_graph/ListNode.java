package _04_tree_graph;

/**
 * Created by Young on 2016/4/2.
 * wang645788@gmail.com
 */
public class ListNode {
    ListNode next = null;
    int val;

    public ListNode (int val) {
        this.val = val;
    }

   /* public void appendTrail (int d){
        ListNode end = new ListNode(d);
        ListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }*/
}
