package _04_tree_graph;

/**
 * Created by Young on 2016/4/3.
 * wang645788@gmail.com
 */
public class _07_getLCA {

	/**
	 * 1、节点的编号（从根节点往下一层层从左到右）就是节点的值
	 * 2、观察后发现节点的编号/2就是父节点的编号，利用这个特性 + 递归，即可得到结果
	 * 3、先判断出编号大的节点，算出此节点的深度，再求出小编号节点的深度，求出两者之差
	 * 4、令两者深度相同后再做比较
     * 总结：方法还是太丑了，其实一个循环，令其中较大的数/2即可
	 * @return   [公共父节点]
	 */
	public static int getLCA(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.exit(-1);
        }
        
        while (a != b) {
        	if (a > b) {
        		a /= 2;
        	} else {
        		b /= 2;
        	}
        }
        return a;

        //方法太丑，换！
		/*if (a <= 0 || b <= 0) {
			System.exit(-1);
		}
		if (a == b) {
			return a / 2;
		}
		int small = a < b ? a : b;
		int big = a < b ? b : a;
		a = small;
		b = big;
		int degreeSM = 0;
		int degreeBig = 0;
		int offset = 0;
		//求出小编号节点的深度
		while(a > 1){
			degreeSM ++;
            a /= 2;
		}
		//求出大编号节点的深度
		while(b > 1){
			degreeBig ++;
            b /= 2;
		}
		offset = degreeBig - degreeSM;
		//令大小数的深度相同
		while(offset > 0){
			big /= 2;
            offset--;
		}
		while (small != big) {
			small /= 2;
			big /= 2;
		}
		return small;*/
    }

    public static void main(String[] args) {
        System.out.println(getLCA(21,11));
    }
}
