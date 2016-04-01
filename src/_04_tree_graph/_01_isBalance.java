package _04_tree_graph;
import java.util.*;

/**
 * 此算法的时间复杂度为O(nlog n)，原因就在于每一个节点会被反复调用并计算高度
 * 改进版详见 _01_isBalance_better.java
 */
public class _01_isBalance {
    public boolean isBalance(TreeNode root) {
        /**
         * 判断当前节点的左子树和右子树的高度差
         */
        if (root == null) {
        	return  true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
        	return false;
        } else {
        	//递归调用，当自己的左孩子/右孩子作为根节点时是否平衡,又开始新的一轮判断
        	//这里巧妙地应用了 && 操作符，递归调用中只要两者有一个为false，则整个表达式为false
        	return isBalance(root.left) && isBalance(root.right);
        }
    }

    public int getHeight (TreeNode node) {
    	if (node == null) {
    		return 0;
    	} else {
    		//这个 + 1 很漂亮，蕴含的思想很简单，在判断节点的左孩子/右孩子的高度前，他们就有一个默认高度 1
    		//所以就不用把已经找到的高度作为参数传进去了，直接累加在外面
    		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    	}
    }
}