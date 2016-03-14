import java.util.Scanner;

/**
 * Created by Young on 2016/3/8.
 * wang645788@gmail.com
 */
public class NetEase_2016_3 {

    public static int[][] yard; // 草地
    public static int n, m, k, xMax, yMax, result = 0;

    public static void main(String[] args) {
        //看下别人是如何做到主函数就两句话且能一直读取的
//        readData();
        Scanner sc = new Scanner(System.in);
        int x, y;
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            yard = new int[n + 1][m + 1];//初始化得到均为0的初始数组
            k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                yard[x][y] += 1;
            }
            result += getMaxAmount();
            clearMushroom(xMax, yMax);
            result += getMaxAmount();
            System.out.println(result);
            restart();
        }
        sc.close();
    }

    private static void restart() {
        result = xMax = yMax = 0;
    }

    //一个扫描透镜一次只能清除一个格子里的一个蘑菇
    private static void clearMushroom(int xMax, int yMax) {
        for (int i = xMax; i < xMax + 3; i++) {
            for (int j = yMax; j < yMax + 3; j++) {
                if(i <= n && j <= m && yard[i][j] > 0){
                    yard[i][j] -= 1;
                }
            }
        }
    }

    //得到一次扫描透镜可以得到的最大的蘑菇数
    public static int getMaxAmount() {
        int num = 0, temp;
        xMax = yMax = 0;
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[i].length; j++) {
                temp = checkMushroom(i, j);
                if (num < temp) {
                    num = temp;
                    xMax = i;
                    yMax = j;
                }
            }
        }
        return num;
    }

    private static int checkMushroom(int x, int y) {
        int num = 0;
        //3*3的扫描透镜，所以应该是 x + 3
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if(i <= n && j <= m && yard[i][j] > 0){
                    num += 1;
                }
            }
        }
        return num;
    }

}
