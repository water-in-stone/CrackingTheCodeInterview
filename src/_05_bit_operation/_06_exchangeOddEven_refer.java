package _05_bit_operation;

import java.util.Scanner;

/**
 * Created by Young on 2016/5/12.
 * wang645788@gmail.com
 */
public class _06_exchangeOddEven_refer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(exchangeOddEven(x));
        }
        sc.close();
    }

    public static int exchangeOddEven(int x){

        //extract odd binary value
        int odd = x & 0xaaaaaaaa;

        //extract even binary value
        int even = x & 0x55555555;
        return (odd >> 1) | (even << 1);
    }
}
