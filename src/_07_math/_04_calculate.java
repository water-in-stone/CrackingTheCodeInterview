package _07_math;

import java.util.Scanner;

/**
 * Created by Young on 2016/5/13.
 * wang645788@gmail.com
 */
public class _04_calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int type = sc.nextInt();
            System.out.println(calc(a, b ,type));
        }
        sc.close();
    }

    public static int calc(int a, int b, int type){
        int result;
        switch (type) {
            case 1:
                result = multiple(a, b);
            break;
            case 0:
                result = divide(a, b);
            break;
            case -1:
                result = subtract(a, b);
            break;
            default:
                result = subtract(a, b);
            break;
        }
        return result;
    }

    public static int multiple(int a, int b){
        int gap = a;
        while(b > 1){
            a += gap;
            b--;
        }
        return a;
    }

    public static int subtract(int a, int b){
        int bOpposite = 0;
        while(b > 0){
            bOpposite += -1;
            b--;
        }
        return a + bOpposite;
    }

    public static int divide(int a, int b){
        int result = 0;
        int gap = b;
        while (a >= b){
            b += gap;
            result ++;
        }
        return result;
    }
}
