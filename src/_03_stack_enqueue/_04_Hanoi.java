package _03_stack_enqueue;

import java.util.*;
/**
 * Created by Young on 2016/3/28.
 * wang645788@gmail.com
 */
public class _04_Hanoi {
    public static void main(String[] args) {
    	int n = 3;
    	Tower[] towerArr = new Tower[3];
    	for (int i = 0; i < n; i++) {
    		towerArr[i] = new Tower(i);
    	}
    	for (int i = n - 1; i >= 0; i--) {
    		towerArr[0].add(i);
    	}
    	towerArr[0].moveDisks(n, towerArr[2], towerArr[1]);
        System.out.println(towerArr[2]);
    }
}

class Tower {
	Stack<Integer> disks; //存放不同大小的盘子
	int index; //表明当前柱子的序号

	public Tower (int index){
		disks = new Stack<>();
		this.index = index;
	}

	public void add(int val){
		if (!disks.isEmpty() && val > disks.peek()) {
			System.out.println("Error!Can not put bigger disk over the small disk");
		} else {
			disks.push(val);
		}
	}

	public int index(){
		return index;
	}

	public void moveTopTo (Tower t) {
		int val = disks.pop();
		System.out.println("move disk from Tower"  + index() + " to Tower" + t.index() + "");
        t.add(val);
	}

	public void moveDisks(int n, Tower destination, Tower buffer){
		if(n > 0){
			//将n-1个盘子从原始柱子上移动到缓冲区,将目标柱子当做缓冲区
			moveDisks(n - 1, buffer, destination);
			//将原始柱子上的盘子移动到目标柱子上
			moveTopTo(destination);
			//将缓冲区的盘子移动到目标柱子上，把原始柱子当做缓冲区
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}
