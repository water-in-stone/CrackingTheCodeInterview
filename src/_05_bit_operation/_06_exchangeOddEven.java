package _05_bit_operation;

import java.util.*;

public class _06_exchangeOddEven{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			System.out.println(exchangeOddEven(x));
		}
		sc.close();
	}

	public static int exchangeOddEven(int x){
		int i = 0, odd, even;
		while(i < 31){
			even = x & 1 << i;
			odd = x & 1 << i + 1;
            //when even is not equal with odd, start change
			if ((even > 0 && odd == 0) || (even == 0 && odd > 0)) {
                // | to set 1, & ~ to set 0
				x = (even == 0) ? (x | 1 << i): (x & ~(1 << i));
				x = (odd == 0) ? (x | 1 << i + 1) : (x & ~(1 << i + 1));
			}
			i += 2;
		}
		return x;
	}
}
