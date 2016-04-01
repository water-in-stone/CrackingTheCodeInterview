package _04_tree_graph;

/**
 * Created by Young on 2016/3/30.
 * wang645788@gmail.com
 */

/**
 * 改进思路，既然原先的getHeight函数已经能得到左右子树的高度，那么这个时候直接判断就好了呀，如果子树不平衡，那么就
 * 直接返回-1代表此树不平衡
 * 空间复杂度为O(H) 时间复杂度为O(N)，H为树的高度
 */
public class _01_isBalance_better {
    public boolean isBalance(TreeNode root) {
       if (checkHeight(root) == -1) {
       		return false;
       } else {
       		return true;
       }
    }

    public int checkHeight (TreeNode node) {
    	if (node == null) {
    		return 0;
    	}

    	//判断左子树是否平衡
        int heightLeft = checkHeight(node.left);
        if (heightLeft == -1) {
            return -1;
        }

        //判断右子树是否平衡
        int heightRight = checkHeight(node.right);
        if (heightRight == -1) {
    		return -1;
    	}

    	if (Math.abs(heightLeft - heightRight) > 1) {
    		return -1;
    	} else {
    		//返回树的高度
    		return Math.max(heightLeft, heightRight) + 1;
    	}
    }
}
