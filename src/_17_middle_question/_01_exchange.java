import java.util.*;

/**
 * Might as well let AB[0] < AB[1], so we get the difference of AB[0] and AB[1]
 * and use it to exchange the value of AB[0] and AB[1].
 * You can understand it on axis
 */
public class _01_exchange{

	public static void main(String[] args) {
		int[] AB = {2, 1};
		exchangeAB(AB);
		System.out.println(AB[0]);
		System.out.println(AB[1]);
	}

	 public static int[] exchangeAB(int[] AB) {
	 	//let AB[0] be the diff of AB[0] and AB[1]
        AB[0] = AB[1] - AB[0];
        AB[1] = AB[1] - AB[0];
        AB[0] = AB[1] + AB[0];
        return AB;
    }
}
