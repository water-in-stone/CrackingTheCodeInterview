package _05_bit_operation;

import java.util.*;

/**
 * Created by Young on 2016/5/12.
 * wang645788@gmail.com
 */
public class _07_findMissing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arrNum = {{0}, {1}, {0, 1}, {1, 1}};
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(findMissing(arrNum, n));
        }
        sc.close();
    }

    public static int findMissing(int[][] numbers, int n){
    	int  i = 0;
    	while(i < n){
			if (i != convert2num(numbers[i])) {
                return i;
    		}
    		i++;
    	}
    	return i;
    }

    public static int convert2num(int[] number){
    	int n = 0;
    	for (int i = 0; i < number.length; i++) {
            if (number[i] == 1) {
	    		n = n | 1 << i;
            }
    	}
    	return n;
    }
}
