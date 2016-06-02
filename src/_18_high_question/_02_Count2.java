package _18_high_question;

/**
 * consider every bit 2
 * 例如：xxxx2 仅仅是个位数字是2的情况 2的高位是0~1999 所以2000*1 2的后面没有低位
 * 同理 计算百位为2的情况：12209 当百位是2的时候，还是有200-299，1200-1299,2200-2299，..11200-11299 有12*100个数，
 * 低位有200-209 10个数 所以当百位=2的时候 是高位数*100+低位数+1；
 * 当百位数 < 2的时候：包括百位的数以及后面的数都不需要考虑，直接：高位数*100；
 * 当百位数 > 2的时候：包括这个百位数 有（高位数+1）*100;
 * 这只是仅仅百位是2的情况，所以之后需要求解的是 十位，千位，万位 为2的情形与百位相一致；
 *
 * Created by Young on 2016/6/1.
 * wang645788@gmail.com
 */
public class _02_Count2 {
    public static void main(String[] args) {
        System.out.println(countNumberOf2s(200));
    }

    public static int countNumberOf2s(int n) {
        int count = 0;
        int low = 0;
        int high = 0;
        int cur = 0;
        int flag = 1;
        while (n / flag != 0) {
            low = n - (n / flag) * flag;
            cur = (n / flag) % 10;
            high = n / (flag * 10);
            if (cur == 1 || cur == 0)
                count += high * flag;
            if (cur == 2)
                count += high * flag + low + 1;
            if (cur > 2)
                count += (high + 1) * flag;
            flag *= 10;
        }
        return count;
    }
}
