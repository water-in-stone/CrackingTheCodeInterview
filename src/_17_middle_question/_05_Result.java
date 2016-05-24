package _17_middle_question;

import java.util.*;

public class _05_Result{

	public static void main(String[] args) {
		int[] result = calcResult("RGBY","GGRR");
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

    //先统计猜中、再统计没有猜中的情况
    public static int[] calcResult(String A, String guess) {
        if (A == null || guess == null) {
            return new int[] { 0, 0 };
        }
        // right 表示猜中
        // unright 表示伪猜中
        int right=0,unright=0;
        // 保存A中的<字符,字符个数>
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length(); ++i){
            // 统计猜中
            if(A.charAt(i) == guess.charAt(i))
                ++right;

            // 获取A中的<字符,字符个数>
            Integer val = map.get(A.charAt(i));
            if(val==null){
                val=1;
            }else{
                val++;
            }
            map.put(A.charAt(i), val);
        }

        // 统计伪猜中的个数（猜中也属于伪猜中）
        for(int i=0;i<guess.length();++i){
            Integer val = map.get(guess.charAt(i));
            if(val != null && val >0){
                unright++;
                val--;
                if(val<0)
                    val=0;
                map.put(guess.charAt(i), val);
            }
        }
        // 从伪猜中当中，去除猜中个数
        unright -=right;
        if(unright<0)unright = 0;
        return new int[] { right, unright };
    }
}
