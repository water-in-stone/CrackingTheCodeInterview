package _04_tree_graph;

import java.util.*;

/**
 * Created by Young on 2016/4/2.
 * wang645788@gmail.com
 */
public class _04_TreeLevel {

    /**
     * 1、还是递归，左子树中符合要求深度的节点 + 左子树中符合要求深度的节点
     * 2、借助一个队列来存储找到的值
     * 3、总结，还是太啰嗦，太丑，而且答案还是有问题，舍弃
     *
     * @param root [根节点]
     * @param dep  [要求的深度]
     * @return [含有某一深度上所有结点的链表，从树的左边开始]
     */
    public static ListNode getTreeLevel(TreeNode root, int dep) {
        ListNode result = null;
        LinkedList<Integer> queue = new LinkedList<>();
        if (root == null || dep < 0) {
            System.exit(-1);
        }
        if (dep == 0) {
            result = new ListNode(root.val);
            return result;
        }
        findNode(root, 0, dep, queue);
        //设置一个哨兵节点head即可，根节点的祖先，便于初始化的代码简化
        if (!queue.isEmpty()) {
            result = new ListNode(queue.poll());
        }
        while (!queue.isEmpty()) {
            appendToTrail(result, queue.poll());
        }
        return result;
    }

    //将找到的对应深度的节点的值全部放到队列中
    public static void findNode(TreeNode root, int curDep, int dep, LinkedList queue) {
        if (curDep == dep) {
            queue.add(root.val);
        }
        if (curDep < dep) {
            if (root.left != null) {
                findNode(root.left, curDep + 1, dep, queue);
            }
            if (root.right != null) {
                findNode(root.right, curDep + 1, dep, queue);
            }
        }
    }

    //自己动手，丰衣足食！这里应该对ListNode增加一个appendToTrail方法
    public static void appendToTrail(ListNode result, int val) {
        //若result为空，则对其进行初始化,且不要对null对象再做赋值
        ListNode end = new ListNode(val);
        ListNode n = result;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(3);
        test.right.left = new TreeNode(4);
        test.right.right = new TreeNode(5);
        System.out.println(getTreeLevel(test, 2));
    }
}
