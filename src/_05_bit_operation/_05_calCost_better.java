package _05_bit_operation;
import java.util.*;

/**
 * Created by Young on 2016/5/12.
 * wang645788@gmail.com
 */
public class _05_calCost_better {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(calcCost(a, b));
        }
        sc.close();
    }

    /**
     * using c & c - 1 to find binary 1 in c
     * @param a
     * @param b
     * @return the count of bit number between a and b
     */
    public static int calcCost(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c & c - 1) {
            count++;
        }
        return count;
    }
}
