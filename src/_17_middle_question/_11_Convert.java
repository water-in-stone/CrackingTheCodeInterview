package _17_middle_question;

import java.util.List;

/**
 * Created by Young on 2016/5/31.
 * wang645788@gmail.com
 */
public class _11_Convert {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        ListNode header = treeToList(root);
        while (header != null) {
            System.out.print(header.val + " ");
            header = header.next;
        }
    }

    public static ListNode treeToList(TreeNode root) {
        //init list with header sentry
        ListNode list = new ListNode(Integer.MIN_VALUE);
        //inorder traversal
        traverse(list, root);
        return list.next;
    }

    public static void traverse(ListNode list, TreeNode node) {
        if (node != null) {
            traverse(list, node.left);
            //appendToTrail
            ListNode next = list;
            while(next.next != null){
                next = next.next;
            }
            next.next = new ListNode(node.val);
            traverse(list, node.right);
        }
    }
}
