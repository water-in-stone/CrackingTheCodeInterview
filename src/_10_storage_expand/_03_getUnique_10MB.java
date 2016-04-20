package _10_storage_expand;

import java.util.*;
import java.io.*;

/**
 * 0、整体思路，在空间受限的情况下，通过多次扫描，增加时间来解决这个问题
 * 1、在只有10MB内存可以用的情况下，将内存划分成区块(4096个区块)，每个区块里有一个整数，
 * 	  代表此区间内出现的整数的个数，作为第一次扫描
 * 2、找出那个区间内包含的整数个数小于理论最大整数个数（1048576）的区间，然后进行第二次扫描
 * 	
 */
public class _03_getUnique_10MB{

	//代表区块的数目
	public static final int BLOCK_SIZE = 4096;	

	//代表每个区间包含的整数的个数，且注意要使用的是1字节 = 8位，表示的最大数位256
	public static final int BIT_SIZE = 1048576;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("file1.txt"));
		int[] block = new int[BLOCK_SIZE];
		byte[] bitField = new byte[BIT_SIZE / 8];
		int n;
		int start = 0;
		while(sc.hasNext()){
			n = sc.nextInt();
			block[n / BIT_SIZE]++;
		}

		for (int i = 0; i < block.length; i++) {
			if (block[i] < BIT_SIZE) {
				start = i * BIT_SIZE;
				break;
			}
		}

		//第二次扫描，将位于那个区间中的数都记录下来
		sc = new Scanner(new FileReader("file1.txt"));
		while(sc.hasNext()){
			n = sc.nextInt();
			if ( n >= start && n < start + BIT_SIZE) {
				bitField[(n - start) / 8] |= 1 << ((n - start) % 8);
			}
		}
		sc.close();

		for (int i = 0; i < bitField.length; i++) {
			for (int j = 0; j < 7; j++) {
				if ((bitField[i] & 1 << j) == 0) {
					System.out.println(start + 8 * i + j);
					return;
				}
			}
		}
	}

}