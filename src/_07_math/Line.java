package _07_math;

/**
 * Created by Young on 2016/5/15.
 * wang645788@gmail.com
 */
//object-oriented
class Line {
    double slope;
    double intercept;
    double epsilon = 0.0000001;

    Line(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    Line() {
        this.slope = Integer.MAX_VALUE;
        this.intercept = Integer.MAX_VALUE;
    }


    public boolean isEquivalent(double a, double b) {
        return Math.abs(a - b) < epsilon;
    }

    /**
     * in order to guarantee precision, we rewrite equals method,
     * and we should also rewrite hashCode method.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            if (isEquivalent(slope, ((Line) obj).slope) && isEquivalent(intercept, ((Line) obj).intercept)) {
                return true;
            } else {
                return false;
            }
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = String.valueOf(slope) + String.valueOf(intercept);
        return str.hashCode();
    }


    public boolean checkCross(Line line) {
        if (line.slope == this.slope && line.intercept != this.intercept) {
            return false;
        } else {
            return true;
        }
    }

    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return intercept;
    }
}
