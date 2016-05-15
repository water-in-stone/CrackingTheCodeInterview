package _07_math;



public class _05_Bipartition{

	public static void main(String[] args) {
		Point a1 = new Point(0, 0);
		Point a2 = new Point(0, 1);
		Point a3 = new Point(1, 1);
		Point a4 = new Point(1, 0);
		Point b1 = new Point(1, 0);
		Point b2 = new Point(1, 1);
		Point b3 = new Point(2, 0);
		Point b4 = new Point(2, 1);
		Point[] A = {a1, a2, a3, a4};
		Point[] B = {b1, b2, b3, b4};
		double[] result = getBipartition(A, B);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	public static double[] getBipartition(Point[] A, Point[] B){
		double[] core1 = getCore(A);
		double[] core2 = getCore(B);
		double[] line = new double[2];
		line[0] = (core1[1] - core2[1]) / (core1[0] - core2[0]);
        line[0] = (line[0] == -0.0) ? -line[0] : line[0];
		line[1] = core1[1] - line[0] * core1[0];
		return line;
	}

	public static double[] getCore(Point[] array){
		double[] core = new double[2];
		int x1 = array[0].x; 
		int x2 = array[0].x; 
		int y1 = array[0].y; 
		int y2 = array[0].y; 
		for(Point a : array){
			if (a.x != x1) {
				x2 = a.x;
			}
			if (a.y != y1) {
				y2 = a.y;
			}
		}
		//divide 2.0 to get double
		core[0] = (x1 + x2) / 2.0;
		core[1] = (y1 + y2) / 2.0;
		return core;
	}
}
