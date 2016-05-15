package _07_math;

import java.util.*;

/**
 * Created by Young on 2016/5/15.
 * wang645788@gmail.com
 */


public class _06_DenseLine {
    public static void main(String[] args) {
        Point a1 = new Point(0, 0);
        Point a2 = new Point(0, 1);
        Point a3 = new Point(1, 1);
        Point a4 = new Point(1, 0);
        Point a5 = new Point(2, 2);
        Point[] p = {a1, a2, a3, a4, a5};
        double[] line = getLine(p, 5);
        System.out.println(line[0]);
        System.out.println(line[1]);
    }

    public static double[] getLine(Point[] p, int n) {
        HashMap<Line, Integer> array = new HashMap<>();
        Line line = new Line();
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                insertLine(p[i], p[j], array);
            }
        }
        //traverse array, but we could simplify it
        for (Map.Entry<Line, Integer> entry : array.entrySet()) {
            Line one = entry.getKey();
            int times = entry.getValue();
            if (times > maxTime) {
                maxTime = times;
                line = one;
            }
        }

        //simplify
        double[] result = {line.getSlope(), line.getIntercept()};
        return result;
    }

    public static void insertLine(Point a, Point b, HashMap<Line, Integer> array) {
        double slope = (a.x - b.x) == 0 ? Integer.MAX_VALUE : (a.y - b.y) / (a.x - b.x);
        double intercept = (slope == Integer.MAX_VALUE) ? Integer.MAX_VALUE : b.y - b.x * slope;
        Line line = new Line(slope, intercept);
        /**
         * most important! containsKey will call equals of line, in order to
         * guarantee the precision!
         */
        if (array.containsKey(line)) {
            int times = array.get(line);
            array.put(line, times + 1);
        } else {
            array.put(line, 1);
        }
    }
}



