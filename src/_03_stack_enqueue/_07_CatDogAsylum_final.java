package _03_stack_enqueue;

import java.util.*;
/**
 * Created by Young on 2016/3/28.
 * wang645788@gmail.com
 */

/**
 * 思路：使用两个队列，一个存放狗，另一个存放猫的序号，并记录进入的时间、
 * 把原先的对单个队列的复杂的操作问题转化为了简单的对两个队列的操作。
 * 在节点中增加一个时间戳即可
 * 这样解耦之后思路清晰且易于理解
 * 分成两个队列就需要关注可能为空的情况
 */
public class _07_CatDogAsylum_final {

    public static LinkedList<Integer> asylumQueue = new LinkedList<>();
    public static ArrayList<Integer> result = new ArrayList<>();
    static Queue4Asyum dogQueue = new Queue4Asyum();
    static Queue4Asyum catQueue = new Queue4Asyum();

	public static ArrayList<Integer> asylum(int[][] ope) {
        int value;
        //根据对应的操作码来进行操作
        for (int i = 0; i < ope.length; i++) {
           switch (ope[i][0]) {
           	case 1:
                //将 i + 1作为时间戳
                if (ope[i][1] > 0) {
                    dogQueue.enqueue(ope[i][1], i + 1);
                } else if(ope[i][1] < 0) {
                    catQueue.enqueue(ope[i][1],i + 1);
                }
           	break;
           	case 2:
                if (ope[i][1] == 0) {
                    //这里根据猫和狗队列的情况，若一哥为空，另一个不为空，则从不为空的队列中取出数据，
                    //若两者都不为空，则判断时间戳后取出，若两者都为空，则不做操作
                    if (!dogQueue.isEmpty() && catQueue.isEmpty()) {
                        result.add(dogQueue.dequeue());
                    } else if(!catQueue.isEmpty() && dogQueue.isEmpty()) {
                        result.add(catQueue.dequeue());
                    }else if(!catQueue.isEmpty() && !dogQueue.isEmpty()) {
                        if (dogQueue.getFirstTime() < catQueue.getFirstTime() ) {
                            result.add(dogQueue.dequeue());
                        } else if(catQueue.getFirstTime() < dogQueue.getFirstTime()){
                            result.add(catQueue.dequeue());
                        }
                    }
                } else if (ope[i][1] == 1) {
                    value = dogQueue.dequeue();
                    if (value != 0) {
                        result.add(value);
                    }                    
                } else if (ope[i][1] == -1) {
                    value = catQueue.dequeue();
                    if (value != 0) {
                        result.add(value);
                    } 
                }
           	break;
           	default:
                System.exit(-1);
           	break;
           }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] ope = {{1,-2},{1,-5},{1,6},{1,6},{2,0},{1,-24},{1,4},{2,0},{1,-89},{2,1},{1,-90},{2,-1},{1,-86},{1,-3},{1,87},{2,-1},{2,0},{2,0},{2,1},{2,0},{1,-43},{2,1},{1,76},{1,-46},{1,70},{1,5},{1,11},{1,-11},{1,16},{2,0},{1,-61},{1,48},{2,1},{1,67},{1,-50},{1,72},{1,30},{1,-59},{1,95},{1,-92},{2,1}};
        ArrayList<Integer> result = asylum(ope);
        System.out.println(result);
    }
}


class Queue4Asyum {
    Node first;
    Node last;

    public void enqueue(int val, int time){
        Node one = new Node<>(val, time);
        if (first == null) {
            first = one;
            last = one;
        } else {
            last.next = one;
            last = one;
        }
    }

    public int dequeue(){
        if (first == null) {
            return 0;
        }
        int value = first.val;
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return value;
    }

    //判断第一个元素的时间戳
    public int getFirstTime(){
        if (first == null) {
            return 0;
        }
        return first.time;
    }

    public boolean isEmpty(){
        return (first == null);
    }
}