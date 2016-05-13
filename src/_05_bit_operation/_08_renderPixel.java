package _05_bit_operation;

import java.util.*;

/**
 * start / 8 to get the index in arrPixel,
 * start % 8 to get the binary position in arrPixel[index]
 * Created by Young on 2016/5/12.
 * wang645788@gmail.com
 */
public class _08_renderPixel {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int[] arrPixel = {0, 0, 0, 0, 0, 0};
        while(sc.hasNext()){
            int start = sc.nextInt();
            int end = sc.nextInt();
            arrPixel = renderPixel(arrPixel, start, end);
            for(int i : arrPixel){
            	System.out.println(i);
            }
        }
        sc.close();
    }

    public static int[] renderPixel(int[] arrPixel, int start, int end){
    	int i, pos;
    	while(start <= end){
    		i = start / 8;
    		pos = start % 8;
    		arrPixel[i] = arrPixel[i] | 1 << pos;
    		start++;
    	}
    	return arrPixel;
    }
}
