package exam_string_1;

import java.util.*;

/**
 * Created by Young on 2016/3/15.
 * wang645788@gmail.com
 */
public class String_1_5_2 {

    public static String zipString(String iniString) {
        //压缩后的新的字符串，这里用StringBuilder方便拼接
        StringBuilder strNew = new StringBuilder();//初始化为""
        char pre; //前一个字符
        int count = 1; //代表字符串出现的次数
        pre = iniString.charAt(0);
        for (int i = 1; i < iniString.length(); i++) {
            if (pre == iniString.charAt(i)) {
                count++;
            } else {
                //直接拼接字符串即可
                strNew.append(pre + "" + count);
                pre = iniString.charAt(i);
                count = 1;
            }
        }
        //将最后一个字符加上
        strNew.append(pre + "" + count);

        /*
        int j = 0;//表示标记数组中的下标
        int length = 1; //表示出现的次数
        //这里用了两个数组来存放压缩的结果，但其实可以直接拼接的
        int[] arrTimes = new int[iniString.length()];
        char[] arrChar = new char[iniString.length()];
        if (iniString.length() < 3) {
            return iniString;
        }
        arrChar[0] = iniString.charAt(0);
        arrTimes[0] = 1;
        for (int i = 1; i < iniString.length(); i++) {
            if (i == iniString.length() - 1 ) {
                if(iniString.charAt(i) != iniString.charAt(i - 1)){
                    arrTimes[j] = length;
                    arrChar[j] = iniString.charAt(i);
                } else {
                  arrTimes[j] = length + 1;
                  arrChar[j] = iniString.charAt(i);  
                }
            } else if (iniString.charAt(i) != iniString.charAt(i - 1)) {
                arrTimes[j] = length;
                arrChar[j] = iniString.charAt(i -1);
                length = 1;
                j++;
            } else {
                length += 1;
            }
        }
        for (int k = 0; k < arrChar.length; k++) {
            if (arrTimes[k] != 0) {
                strNew.append(arrChar[k]);
                strNew.append(arrTimes[k]);
            }
        }*/
        if (strNew.toString().length() > iniString.length()) {
            return iniString;
        } else {
            return strNew.toString();
        }

    }

    public static void main(String[] args) {
        String s2 = "aabcccccaaa";
        System.out.println(zipString(s2));
    }
}
