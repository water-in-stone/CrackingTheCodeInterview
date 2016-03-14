import java.util.Scanner;
public class NetEase_2016_2{
	public static void main(String[] args) {
        class Position {
            private int x;
            private int y;

            Position(int x, int y){
                this.x = x;
                this.y = y;
            }

            public void setPosition(int valueX, int valueY){
                this.x = valueX;
                this.y = valueY;
            }

            public int getX(){
                return this.x;
            }

            public int getY(){
                return this.y;
            }

            public double getDistance(){
              // ^ 在Java中表示按位异或的意思，如果想要平方一个数，记得用Math.pow();
              //return Math.sqrt(this.x ^ 2 + this.y ^ 2);
                return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
            }
        }

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int fireDistance = sc.nextInt();
			if(fireDistance < 0){
				System.exit(0);
			}
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			Position one = new Position(x1,y1);
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			Position two = new Position(x2,y2);
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			Position three = new Position(x3,y3);
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			Position enemy = new Position(x0,y0);
			one.setPosition(one.getX() - enemy.getX(), one.getY() - enemy.getY());
            two.setPosition(two.getX() - enemy.getX(), two.getY() - enemy.getY());
			three.setPosition(three.getX() - enemy.getX(), three.getY() - enemy.getY());
			int damage = 0;
			if(one.getDistance() <= fireDistance) damage++;
            if(two.getDistance() <= fireDistance) damage++;
			if(three.getDistance() <= fireDistance) damage++;
            System.out.println(damage + "x");
        }
		sc.close();
	}
}