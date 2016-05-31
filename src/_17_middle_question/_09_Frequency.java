package _17_middle_question;

/**
 * Created by Young on 2016/5/31.
 * wang645788@gmail.com
 */
public class _09_Frequency {
    public static void main(String[] args) {
        String[] article = {"hello", "hello", "world"};
        System.out.println(getFrequency(article, article.length, "hello"));
    }

    public static int getFrequency(String[] article, int n, String word) {
    	int count = 0;
        for (int i = 0; i < n; i++) {
        	if (article[i].equals(word)) {
                count++;
        	}
        }
        return count;
    }
}
