package exam_string_1;
import java.util.*;
/**
 * Created by Young on 2016/3/23.
 * wang645788@gmail.com
 */
public class String_1_1 {
    
    /**
     * PS:此处不允许使用额外的数据结构，则时间复杂度为O(n^2),用两趟遍历
     * @param  iniString [给定的字符串]
     * @return           [若有重复则返回false,否则返回true]
     */
    public static boolean checkDifferent(String iniString) {
    	if (iniString == null) {
    		System.exit(0);
    	}
    	int length = iniString.length();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if(iniString.charAt(i) == iniString.charAt(j) && i != j){
					return false;
				}		
			}			
		}
		return true;				
    }

    public static void main(String[] args) {
        System.out.println(checkDifferent("qyuiewnkfvd"));
    }
}
