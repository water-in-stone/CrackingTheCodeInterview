package _05_bit_operation;

import java.util.*;

public class _01_binInsert{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int j = sc.nextInt();
			int i = sc.nextInt();
			System.out.println(binInsert(n, m, j, i));
		}
		sc.close();
	}

	public static int binInsert(int n, int m, int j, int i){
		int m1 = m << j;
		return n | m1;
	}
}
