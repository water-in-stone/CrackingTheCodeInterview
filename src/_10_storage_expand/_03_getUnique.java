// package _10_storage_expand;

import java.util.*;
import java.io.*;

public class _03_getUnique{

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("file.txt"));
		/*long numberOfInt = (long)(Integer.MAX_VALUE) + 1;
		byte[] bytes = new byte[(int)(numberOfInt / 8)];*/
		byte[] bytes = new byte[200];
		while(sc.hasNext()){
			int n = sc.nextInt();
			/**
			 * 用OR操作符设置字节数组中那个整数对应的位置
			 * 例如10对应于字节数组的第二行的第3位
			 */
			bytes[n / 8] |= 1 << (n % 8);
		}
		System.out.println(find(bytes));
		sc.close();
	}

	public static int find(byte[] bytes){
		for (int i = 0; i < bytes.length; i++) {
			for (int j = 0; j < 7; j++) {
				//坚持字节的各个比特位，若发现比特位为0，则返回出对应的整数
				if ((bytes[i] & 1 << j) == 0) {
					return 8 * i + j;
				}
			}
		}
 		return Integer.MAX_VALUE;
	}
}
