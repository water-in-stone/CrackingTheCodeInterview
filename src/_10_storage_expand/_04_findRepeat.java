package _10_storage_expand;

import java.util.*;
import java.io.*;

/**
 * 1、4KB内存大约有32000个比特，与题目中整数的范围正好一致
 * 2、每一个比特位代表一个整数，依次读取数组中的元素，将其放到对应的比特位上
 * 3、放置到对应的比特位时，若发现此比特位为1，则代表出现了重复元素，直接打印
 */
public class _04_findRepeat{

	public static final int RANGE = 4096;;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("file.txt"));
		byte[] bytes = new byte[RANGE * 8];
		int value;
		while(sc.hasNext()){
			value = sc.nextInt();
			if (bytes[value] == 1) {
				System.out.println(value);
			} else {
				bytes[value] = 1;
			}
		}
		sc.close();
	}
}
