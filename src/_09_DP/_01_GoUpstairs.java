package _09_DP;
import java.util.*;

/**
 * 缓存递归的结果
 */
public class _01_GoUpstairs{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(calcuWays(n));
		}
		sc.close();
	}

	public static int calcuWays(int n){
		//根据台阶的阶数n来初始化数组，节省空间!
		int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for(int i=3;i<=n;i++){
        	//取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c,做到避免溢出
            f[i]=((f[i-1]+f[i-2])%1000000007+f[i-3])%1000000007;
        }        
        return f[n]%1000000007;
	}
}

