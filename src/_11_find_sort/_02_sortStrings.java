package _11_find_sort;

import java.util.*;

public class _02_sortStrings {

    public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
        String[] arrStr = {"Young", "oungY","ab", "ba", "abc", "cba"};
        ArrayList<String> result = sortStrings(arrStr, 4);
        for (String str : result) {
            System.out.println(str);
        }
        /*while(sc.hasNext()){
		}
		sc.close();*/
    }

    public static ArrayList<String> sortStrings(String[] str, int n) {
        ArrayList<String> result = new ArrayList<>();
        for (String val : str) {
            result.add(val);
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (isEquivalent(result.get(i), result.get(j))) {
                    result.remove(j);
                    j--;
                }
            }
        }
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //sort by lexicographically
                return o1.compareTo(o2);
            }
        });
        return result;
    }

    public static boolean isEquivalent(String s1, String s2) {
        return bubbleSort(s1).equals(bubbleSort(s2));
    }

    public static String bubbleSort(String s) {
        char[] arrChar = s.toCharArray();
        char temp;
        for (int i = 0; i < arrChar.length; i++) {
            for (int j = i + 1; j < arrChar.length; j++) {
                if (arrChar[i] > arrChar[j]) {
                    temp = arrChar[i];
                    arrChar[i] = arrChar[j];
                    arrChar[j] = temp;
                }
            }
        }
        return String.valueOf(arrChar);
    }
}
