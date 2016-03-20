package _02_LinkedList;
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
    	//其实这里还是用列表比较好，这样不管多长都可以判断
        /*int[] arrValue = new int[400];
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
        return true;*/
        if (pHead == null) {
        	return false;
        }
        ArrayList<Integer> listValue = new ArrayList<>();
        int length;
        while(pHead.next != null){
        	listValue.add(pHead.val);
        	pHead = pHead.next;
        }
        listValue.add(pHead.val);
        length = listValue.size();
        for (int i = 0; i < length / 2; i++) {
        	if(!listValue.get(i).equals(listValue.get(length - 1 - i))){
        		return false;
        	}
        }
        return true;
    }
}

