package other;
import java.util.*;

/**
 * simple way to solve this problem, but it is not elegant
 */

public class LCS{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			System.out.println(getLCS(s1, s2));
		}
		sc.close();
	}

	public static String getLCS(String s1, String s2){
		int index = 0;
		int maxLength = 0;
		int temp;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				temp = getLength(s1, s2, i, j);
				if (maxLength < temp) {
					maxLength = temp;
					index = i;
				}
			}
		}
		if (maxLength == 0) {
			return "";
		} else {
			return s1.substring(index, index + maxLength);
		}
	}

	public static int getLength(String s1, String s2, int index1, int index2){
		int length1 = s1.length();
		int length2 = s2.length();
		int length = 0;
		while(index1 < length1 && index2 < length2 && s1.charAt(index1) == s2.charAt(index2)){
			index1++;
			index2++;
			length++;
		}	
		return length;
	}
}
