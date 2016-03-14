import java.util.Scanner;

/**
 * Created by Young on 2016/3/1.
 * wang645788@gmail.com
 */
public class NetEase_2016 {

    public static int fight (int initialPower, int[] ghostArr) {
        int powerStart = initialPower;
        for (int i = 0; i < ghostArr.length; i++) {
            int ghost = ghostArr[i];
            if (ghost <= powerStart) {
                powerStart += ghost;
            } else {
                powerStart += archimedes(ghost, powerStart);
            }
        }
        return powerStart;
    }

    //阿基米德辗转相除法，且a > b，返回最大公约数, 且应考虑到特殊情况0！
    public static int archimedes (int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int remainder = a % b;
            while (remainder != 0){
                a = (a-remainder)/(a/b);//辗转相除后得到的较大的被除数
                b = remainder;
                remainder = a % b;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //反复读取示例
        while(scanner.hasNext()){
            int ghostNum = scanner.nextInt();
            int initialPower = scanner.nextInt();
            if (ghostNum < 0 || ghostNum > 10000 || initialPower < 0) {
                System.out.println("Error input!");
                System.exit(0);
            }
            int[] ghostArr = new int[ghostNum];
            for (int i = 0; i < ghostArr.length; i++) {
                int ghost = scanner.nextInt();
                if (ghost < 0) {
                    System.out.println("Error");
                    System.exit(0);
                } else {
                    ghostArr[i] = ghost;
                }
            }
            int result = fight(initialPower, ghostArr);
            System.out.println(result);
        }
        scanner.close();
    }
}
