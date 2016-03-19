package exam_string_1;

import java.util.*;

/**
 * Created by Young on 2016/3/15.
 * wang645788@gmail.com
 */
public class String_1_5 {

    //这里输入的字符串只包含大小写字母
    public static String zipString(String iniString) {
        //使用一个散列表，对原有的字符串数组做一个遍历
        //新建一个和原有数组一样大小的数组Char[] strNew
        //依然是遍历原有的字符串数组，根据对应的字母在散列表中的次数来在strNew中输入对应的单个Char
        if (iniString.length() < 3) {
            return iniString;
        }
//		Map<Char, Integer> hashMap = new HashMap<>(); //Char是Character的缩写
        Map<Character, Integer> hashMap = new HashMap<>();
        int num;
        for (int i = 0; i < iniString.length(); i++) {
        	//hashMap.get() 的返回值就是一开始定义的value的类型，且若找不到，则返回null
            if (hashMap.get(iniString.charAt(i)) == null) {
                hashMap.put(iniString.charAt(i), 1);
            } else {
                num = hashMap.get(iniString.charAt(i));
                hashMap.put(iniString.charAt(i), num + 1);
            }
        }
        
        StringBuilder strNew = new StringBuilder();
        int length;
        //根据散列表中存放的单个字符的出现次数来拼凑出压缩后的字符串
        for (int k = 0; k < iniString.length(); k++) {
            strNew.append(iniString.charAt(k));
            length = hashMap.get(iniString.charAt(k));
            //直接令字符串""和数字相加
            strNew.append("" + length);
            k += length - 1;
        }
        if (strNew.toString().length() > iniString.length()) {
            return iniString;
        } else {
            return strNew.toString();
        }
    }

    public static void main(String[] args) {
        String strTest = "welcometonowcoderrrrr";
        System.out.println(zipString(strTest));
        System.out.println("" + 5);
    }
}
