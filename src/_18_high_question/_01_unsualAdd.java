package _18_high_question;

/**
 * Created by Young on 2016/6/1.
 * wang645788@gmail.com
 */
public class _01_unsualAdd {
    public static void main(String[] args) {
    	System.out.println(addAB(12, 15));//27
    }

    public static int addAB(int A, int B) {
    	int num = 0;
    	int carry = 0;
    	int i = 0;
    	int bitA, bitB, sum = 0;
    	while (i < 31) {
    		bitA = (A & (1 << i)) > 0 ? 1 : 0;
    		bitB = (B & (1 << i)) > 0 ? 1 : 0;
            //handle several condition
    		if (bitA == 0 && bitB == 0) {
                sum = (carry == 0) ? 0 : 1;
                carry = (carry == 0) ? 0 : 0;
    		} else if ((bitA == 1 && bitB == 0) || (bitA == 0 && bitB == 1)) {
                sum = (carry == 0) ? 1 : 0;
                carry = (carry == 0) ? 0 : 1;
    		} else if (bitA == 1 && bitB == 1) {
                sum = (carry == 0) ? 0 : 1;
                carry = (carry == 0) ? 1 : 1;
    		}
    		num = num | (sum << i);
    		i++;
    	}
    	return num;
    }
}
