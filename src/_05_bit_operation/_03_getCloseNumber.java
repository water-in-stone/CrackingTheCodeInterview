package _05_bit_operation;
import java.util.*;

/**
 * solve it with force, but we could solve it
 * when we look the constitute of number
 */
public class _03_getCloseNumber{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] arrCloseNum = getCloseNumber(n);
			System.out.println(arrCloseNum[0]);
			System.out.println(arrCloseNum[1]);
		}
		sc.close();
	}

	public static int[] getCloseNumber(int x){
		int smaller = x - 1;
		int bigger = x + 1;
		int length = getLength(x);
		int[] result = new int[2];
		while (getLength(smaller) != length) {
			smaller--;
		}
		while(getLength(bigger) != length){
			bigger++;
		}
		result[0] = smaller;
		result[1] = bigger;
		return result;
	}

	/**
	 * return the number of 1 in binary x
	 * @param  x [description]
	 * @return   [description]
	 */
	public static int getLength(int x){
		int i = 0;
		int length = 0;
		while (i < 32) {
			if ((x & 1 << i) != 0) {
				length++;
			}
			i++;
		}
		return length;
	}
}
