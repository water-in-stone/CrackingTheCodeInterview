package _04_tree_graph;

import java.util.LinkedList;

/**
 * Created by Young on 2016/4/2.
 * wang645788@gmail.com
 */
public class _04_TreeLevel_better {

    ListNode head = new ListNode(-1);
//    ListNode p = head.next; 这里依然是把p给预先保存起来，
//    关键在p是一个确定的被初始化的节点
    ListNode p = head;
    /**
     * 1、还是递归，左子树中符合要求深度的节点 + 左子树中符合要求深度的节点
     * 2、在方法之外定义好ListNode
     *
     * @param root [根节点]
     * @param dep  [要求的深度]
     * @return [含有某一深度上所有结点的链表，从树的左边开始]
     */
    public ListNode getTreeLevel(TreeNode root, int dep) {
        if (root == null || dep <= 0) {
            return null;
        }
        if (dep == 1) {
            p.next = new ListNode(root.val);
            p = p.next;
        }
        getTreeLevel(root.left, dep - 1);
        getTreeLevel(root.right, dep - 1);
        return head.next;
    }

}
