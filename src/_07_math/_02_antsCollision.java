package _07_math;

import java.util.Scanner;

/**
 * Created by Young on 2016/5/13.
 * wang645788@gmail.com
 */
public class _02_antsCollision {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()){
    	    int n = sc.nextInt();
    	    System.out.println(antsCollision(n));
    	}
    	sc.close();
    }

    public static double antsCollision(int n){
    	return 	1 - Math.pow(0.5, n - 1);
    }
}
