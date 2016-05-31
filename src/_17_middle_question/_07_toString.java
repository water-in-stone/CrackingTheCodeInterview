package _17_middle_question;
import java.util.*;

public class _07_toString {

    public static void main(String[] args) {
        System.out.println(toString(1234));
    }

    private static String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String toString(int x) {
        if (x == 0) return "Zero";
        return helper(x);
    }

    private static String helper(int num) {
        String result = "";
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000)
            result = helper(num / 1000) + " Thousand" + (num % 1000 > 0 ? "," : " ") + helper(num % 1000);
        else if (num < 1000000000)
            result = helper(num / 1000000) + " Million" + (num % 1000000 > 0 ? "," : " ") + helper(num % 1000000);
        else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
}
