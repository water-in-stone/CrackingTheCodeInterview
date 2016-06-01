package _18_high_question;

/**
 * Created by Young on 2016/6/1.
 * wang645788@gmail.com
 */
public class _01_unusualAdd_better {
    public static void main(String[] args) {
        System.out.println(addAB(12, 15));
    }

    public static int addAB(int A, int B) {
        if (B == 0) {
            return A;
        }
        int sum = A ^ B;
        int carry = (A & B) << 1;
        return addAB(sum, carry);
    }
}
