package _04_tree_graph;
import java.util.*;

/**
 * Created by Young on 2016/4/3.
 * wang645788@gmail.com
 */

/**
 * 1、遍历保持不变，将查找的值设置为全局变量
 * 2、中序遍历也可以用栈来实现
 */
public class _06_Successor {
	
	private static int succValue = -1;//默认的后继值设为-1
	private static boolean flag = false;//标记是否找到

    public static int findSucc(TreeNode root, int p) {
        // write code here
        if (p < 0 || root == null) {
        	return -1;
        }
       	traverseLDR(root, p);
       	return succValue;
    }

    //先考虑存在值为p的节点的情况
    public static void traverseLDR(TreeNode root, int p){
    	if (root == null) {
    		return;
    	}
		traverseLDR(root.left, p);
        //若找到节点值为p的节点，则将flag置为true，这里利用了各个节点值不一样的性质
    	if (root.val == p && !flag) {
    		flag = true;
    	}
        //在发现值为p的节点的情况下，将值取出，且将flag值为false
    	if (root.val != p && flag) {
    		succValue = root.val;
    		flag = false;
    	}
		traverseLDR(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(3);
        test.left.left = new TreeNode(7);
        test.left.right = new TreeNode(8);
        test.right = new TreeNode(4);
        test.right.left = new TreeNode(5);
        test.right.left.right = new TreeNode(6);
        System.out.println(findSucc(test,8));
    }

}
