package _09_DP;
import java.util.*;

public class _05_getPermutation{

	public static void main(String[] args) {
		getPermutation("ABC");
	}

	public static ArrayList<String> getPermutation(String A) {
        ArrayList<String> result = new ArrayList<>();
        int length = A.length();
        boolean[] isVisited = new boolean[length];
        permutation(result, A, 0, "", isVisited);
        //集合的排序,自定义一个排序函数
        Collections.sort(result, new Comparator<String>() {
 
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });
        return result;
    }


    //回溯法生成所有的字符串下标的排列组合
    public static void permutation(ArrayList<String> result, String A, int cur, String str, boolean[] isVisited) {
    	if (cur == A.length()) {
    		result.add(str);
    		return;
    	} else {
            //结合每次递归时字符数组是否被访问，将所有可能的字符进行拼接
    		for (int i = 0; i < A.length(); i++) {
    			if (!isVisited[i]) {
    				isVisited[i] = true;
                    String nextStr = str + A.charAt(i);
    				permutation(result, A, cur + 1, nextStr , isVisited);
    				isVisited[i] = false;
    			}
    		}
    	}
    }
}
