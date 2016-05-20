package _11_find_sort;

public class _07_ArhatOverlap{

	public static void main(String[] args) {
		int[][] actors = {{5, 6}, {1, 2}, {3, 4}, {7, 8}};
		System.out.println(getHeight(actors, 4));
	}

	public static int getHeight(int[][] actors, int n){
		if (n < 1) {
			return 0;
		}
		int[] temp;
        //sort height ascend
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (actors[i][0] > actors[j][0]) {
					temp = actors[i];
					actors[i] = actors[j];
					actors[j] = temp;
				}
			}
		}
		int max = 1;
		int[] dpNum = new int[n];
		dpNum[0] = 1;
		for (int i = 1; i < n; i++) {
			int num = 0;
			for (int j = i - 1; j >= 0 ; j--) {
                //get the length of increasing sub array
				if (actors[j][1] < actors[i][1]) {
					num = num < dpNum[j] ? dpNum[j] : num;					
				}
			}
			dpNum[i] = num + 1;
			max = Math.max(num + 1, max);
		}
		return max;
	}
}
