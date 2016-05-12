package _05_bit_operation;
import java.util.*;


public class _05_calcCost{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(calcCost(a, b));
		}
		sc.close();
	}

	public static int calcCost(int a, int b){
        int c = a ^ b;
        int n = 0;
        int i = 0;
        while(i < 32){
            if((c & 1 << i) != 0){
                n++;
            }
            i++;
        }
        return n;
	}	
}
