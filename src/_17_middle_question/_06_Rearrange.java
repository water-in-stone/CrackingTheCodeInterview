package _17_middle_question;

/**
 * becasue the array is 
 *（1）从左到右找出N
 * 如果当前元素小于之前的最大元素则说明当前元素应处于[M N]无序序列中而且当前元素是当前最大下标的无序元素所以更新N为当前元素下标。
 *（2）从右到左找出M
 * 如果当前元素大于之前的最小元素则说明当前元素应处于[M N]无序序列中而且当前元素是当前最小下标的无序元素所以更新M为当前元素下标
 * 
 * Created by Young on 2016/5/31.
 * wang645788@gmail.com
 */
public class _06_Rearrange {
    public static void main(String[] args) {
		int[] A2 = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		int[] result = findSegment(A2, A2.length);
		System.out.println(result[0]);
		System.out.println(result[1]);
    }

    public static int[] findSegment(int[] A, int n) {
    	int[] result = new int[2];
    	int max = A[0];
    	int min = A[n - 1];
    	for (int i = 1; i < A.length; i++) {
    		if (A[i] >= max) {
    			max = A[i];
    		} else {
    			result[1] = i;
    		}
    	}
    	for (int j = n - 1; j > 0; j--) {
    		if (A[j] <= min) {
    			min = A[j];
    		} else {
    			result[0] = j;
    		}
    	}
    	return result;
    }
}
