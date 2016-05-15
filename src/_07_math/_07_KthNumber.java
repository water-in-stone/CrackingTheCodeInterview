package _07_math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * Created by Young on 2016/5/15.
 * wang645788@gmail.com
 */
public class _07_KthNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(findKth(n));
        }
        sc.close();
    }

    /**
     * 时间复杂度O(N),3个素数因子3、5、7分为三个队列q3,q5,q7，其中最初存放3，5，7
     * 之后每次添加找到三个队列头中最小的数，起初为3，将3移出队列q3后，在q3添加3*3，在q5添加3*5,q7中添加3*7
     * 此时可知q3{3*3},q5{5,3*5},q7{7,3*7}
     * 下一轮找到最小数为5，重复上述步骤，将5从q5移出，添加5*5到q5，因为5*3已经添加过所以不需要添加到q3中
     * 将5*7添加到q7，结果q3{3*3},q5{3*5,5*5},q7{7,3*7,5*7}
     * 依次找到第k个数
     */
    public static int findKth(int k){
        if(k < 0){
            return 0;
        }
        int val = 0;
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        Queue<Integer> q7 = new LinkedList<>();
        q3.add(1);
        for(int i = 0 ; i <= k; i++){
            int v3 = q3.size() > 0? q3.peek() : Integer.MAX_VALUE;
            int v5 = q5.size() > 0? q5.peek() : Integer.MAX_VALUE;
            int v7 = q7.size() > 0? q7.peek() : Integer.MAX_VALUE;
            val = Math.min(v3, Math.min(v5,v7));
             
            if(val == v3){
                q3.remove();
                q3.add(val*3);
                q5.add(val*5);
            }else if(val == v5){
                q5.remove();
                q5.add(val*5);
            }else if(val == v7){
                q7.remove();
            }
            q7.add(val*7);
        }
        return val;
    }
}
