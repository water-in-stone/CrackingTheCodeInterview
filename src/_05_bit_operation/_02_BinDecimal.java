package _05_bit_operation;

import java.util.*;
/**
 * when n > 0 && n < 1, we can n *= 2 to get the binary digit,
 * actually, we do << operation
 * Created by Young on 2016/5/11.
 * wang645788@gmail.com
 */
public class _02_BinDecimal {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()){
    		double n = sc.nextDouble();
            System.out.println(printBin(n));
        }
    	sc.close();
    }

    public static String printBin(double n){
    	if (n < 0 || n > 1) {
    		return "Error";
    	}
		StringBuilder str = new StringBuilder();
        str.append("0.");
		while(n > 0){
			if (str.length() > 32) {
				return "Error";	
			}
			n *= 2;
			if (n >= 1) {
				str.append("1");
				n -= 1;
			} else {
				str.append("0");
			}
		}
		return str.toString();    	
    }
}
