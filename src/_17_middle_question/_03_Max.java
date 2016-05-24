package _17_middle_question;

import java.util.*;

public class _03_Max {

    public static void main(String[] args) {
        System.out.println(getMax(3, 10));
    }

    public static int getMax(int a, int b) {
        int k = sign(a - b);
        int q = reverse(k);
        return a * q + b * k;
    }

    //if a > 0 then return 0, otherwise return 1
    //we still can optimize when a - b exceeded Integer.MAX_VALUE
    public static int sign(int a) {
        return (a >> 31) & 1;
    }

    //i = 0 return 1, i = 1 return 0
    public static int reverse(int i) {
        return i ^ 1;
    }
}

