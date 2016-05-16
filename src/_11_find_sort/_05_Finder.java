package _11_find_sort;

import java.util.*;


/**
 * when find str[mid] = "", we try to find first string which is not equal "", get its index as mid
 * 1、when str[mid].equals(x), return mid;
 * 2、when x.compareTo(str[mid]) > 0, the x is on the right of  mid, then low = mid + 1.
 * 3、when x.compareTo(str[mid]) < 0, the x is on the left of  mid, then high = mid - 1.
 * Created by Young on 2016/5/16.
 * wang645788@gmail.com
 */
public class _05_Finder{

	public static void main(String[] args) {
		String[] arr = {"","","","","B","JIKLPORFPLB","LELNRIRPIAF","LNKVIISCK","ORZUH","OZJCZRQVQOP","QNZZRPFJ","RMKZFB","ZGK"};
		System.out.println(findString(arr, 13, "JIKLPORFPLB"));
	}

	public static int findString(String[] str, int n, String x) {
       	int low = 0;
       	int high = n - 1;
       	int mid;
       	while (low <= high) {
            mid = (low + high) / 2;
            if (str[mid].equals("")) {
                int index = mid;
            	while (index >= low && str[index].equals("")) {
                    index--;
            	}
                if (index < low) {
                    low = mid + 1;
                } else if (str[index].equals(x)) {
                    return index;
                } else if (x.compareTo(str[index]) > 0) {
                    low = index + 1;
                } else if (x.compareTo(str[index]) < 0) {
                    high = index - 1;
                }
            } else {
            	if (x.compareTo(str[mid]) < 0) {
            	    high = mid - 1;
            	} else if (x.compareTo(str[mid]) > 0) {
            	    low = mid + 1;
            	} else {
            	    return mid;
            	}
            }
        }
        return -1;
    }
}
