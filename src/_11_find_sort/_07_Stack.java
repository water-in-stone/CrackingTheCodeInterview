package _11_find_sort;

import java.util.*;

/**
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _07_Stack {
    public static void main(String[] args) {
        int[] men = {1, 6, 2, 5, 3, 4};
        System.out.println(getHeight(men, men.length));
    }

    public static int getHeight(int[] men, int n){
        Arrays.sort(men);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < men.length; i++) {
            if (!result.contains(men[i])) {
                result.add(men[i]);
            }
        }
        return result.size();
    }
}
