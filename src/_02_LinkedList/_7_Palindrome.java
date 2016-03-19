import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
// 思路：
// 遍历列表且将所有的数存到数组里
// 对数组进行对半比对，若不相同，则直接返回false
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        int[] arrValue = new int[400];
        int index = 0; //表示要取值放入值数组的初始下标
        while (pHead.next != null) {
        	arrValue[index++] = pHead.val;
        	pHead = pHead.next;
        }
        arrValue[index++] = pHead.val;
        for (int i = 0; i < index / 2; i++) {
        	if(arrValue[i] != arrValue[index - 1 - i]){
        		return false;
        	}
        }
        return true;
    }
}