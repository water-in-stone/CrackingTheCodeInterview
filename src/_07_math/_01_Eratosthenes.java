package _07_math;

import java.util.Scanner;

/**
 * essence : delete all the common multiple of prime number
 * Created by Young on 2016/5/13.
 * wang645788@gmail.com
 */
public class _01_Eratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            boolean[] flags = getByEratosthenes(n);
            printPrime(flags);
        }
        sc.close();
    }

    public static boolean[] getByEratosthenes(int n){
        boolean[] flags = new boolean[n + 1];
        init(flags);
        int prime = 2;
        while(prime <= n){
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    //init all the number as prime
    public static void init(boolean[] flags){
        for (int i = 0; i < flags.length; i++) {
            if(i > 1){
                flags[i] = true;
            }
        }
    }

    //delete all the common multiple of the given prime
    public static void crossOff(boolean[] flags, int prime){
        for (int i = 2; i < flags.length; i++) {
            if (flags[i] && i != prime && (i % prime == 0)) {
                flags[i] = false;
            }
        }
    }

    //look for next prime
    public static int getNextPrime(boolean[] flags, int prime){
        int length = flags.length;
        prime++;
        while(prime < length && !flags[prime]){
            prime++;
        }
        return prime;
    }

    public static void printPrime(boolean[] flags){
        for (int i = 2; i < flags.length; i++) {
            if (flags[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
