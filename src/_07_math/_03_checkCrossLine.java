package _07_math;

import java.util.Scanner;
/**
 * Created by Young on 2016/5/13.
 * wang645788@gmail.com
 */

public class _03_checkCrossLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double slope = sc.nextDouble();
            double intercept = sc.nextDouble();
            Line line1 = new Line(slope, intercept);
            double slope2 = sc.nextDouble();
            double intercept2 = sc.nextDouble();
            Line line2 = new Line(slope2, intercept2);
            System.out.println(line1.checkCross(line2));
        }
        sc.close();
    }
}
