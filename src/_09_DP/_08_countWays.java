package _09_DP;
import java.util.*;

//force solution, time complexity is not ok
public class _08_countWays{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(makeChange(n, 25));
		}
		sc.close();
    }


	public static int makeChange(int n, int demon){
		int next_demon = 0;
		int ways = 0;
		switch (demon) {
			case 25:
				next_demon = 10;
			break;
			case 10:
				next_demon = 5;
			break;
			case 5:
				next_demon = 1;
			break;
			case 1:
				return 1;
			default:
			break;
		}
		for (int i = 0; i * demon < n; i++) {
			ways += makeChange(n - i * demon, next_demon) % 1000000007;
		}
		return ways % 1000000007;
	}
}
