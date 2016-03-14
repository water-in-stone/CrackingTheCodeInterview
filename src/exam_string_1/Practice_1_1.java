package exam_string_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Young on 2016/3/8.
 * wang645788@gmail.com
 */
public class Practice_1_1 {
    public static void main(String[] args) {
        //自定义模板
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] charArr = s.toCharArray();
            Map<Character, Integer> hm = new HashMap<>();
            Character c;
            Boolean flag = true;
            for (int i = 0; i < charArr.length; i++) {
                c = charArr[i];
                if(hm.get(c) == null){
                    hm.put(c,1);
                } else {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
        sc.close();
    }
}
