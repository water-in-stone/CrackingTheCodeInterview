package _03_stack_enqueue;
import java.util.*;
/**
 * Created by Young on 2016/3/28.
 * wang645788@gmail.com
 */

/**
 * 亲手实践部：构造一个特殊的队列，这个队列能够对队列中的某个元素进行删除，并返回被删除元素的值
 * 这样的队列在只有单项的一个列表时需要考虑的因素太多(是否为最后一项，first和last对状态的判断)，
 * 把两个队列混合在一起是很麻烦的，这边要做解耦。下面的代码即使实现了也不是好方法，废弃。
 * （PS：其实全部做到一个队列中也可以，但自己手动发明一个能对中间的节点进行操作的新队列没有必要，考虑直接用动态数组ArrayList来做）
 */

class QueueAsyum {
    Node first;
    Node last;

    public void enqueue(int val){
        Node one = new Node<>(val);
        if (first == null) {
            first = one;
            last = one;
        } else {
            last.next = one;
            last = one;
        }
    }

    public int dequeue(){
        if (first == null) {
            return Integer.MAX_VALUE;
        }
        int value = first.val;
        first = first.next;
        return value;
    }

    public Integer dequeueDog(){
        Node nodeSearch = first;
        Node prevNode = first;
        int val;
        while (nodeSearch != null && nodeSearch.val < 0) {
            prevNode = nodeSearch;
            nodeSearch = nodeSearch.next;
        }
        //若查找到最后也没有发现Dog的编号，则返回0
        if (nodeSearch == null) {
            return 0;
        }
        val = nodeSearch.val;
        //若在最后一个节点的时候找到，则依靠上一个节点进行删除操作
        if (nodeSearch.next == null) {
            last.val = prevNode.val;
        } else {
            remove(nodeSearch);
        }
        return val;
    }

    public Integer dequequeCat(){
        Node nodeSearch = first;
        Node prevNode = first;
        int val;
        while (nodeSearch != null && nodeSearch.val > 0) {
            prevNode = nodeSearch;
            nodeSearch = nodeSearch.next;
        }
        if (nodeSearch == null) {
            return 0;
        }
        val = nodeSearch.val;
        if (nodeSearch.next == null) {
            last.val = prevNode.val;
        } else {
            remove(nodeSearch);
        }
        return val;
    }

    public boolean remove(Node pNode){
        if (pNode == null) {
            return false;
        }
        //将当前元素的值用它的后继来替代
        //Java中传递对象传的是对象引用的拷贝，所以必须对对象本身进行操作才能真正删除
        Node next = pNode.next;
        pNode.val = next.val;
        pNode.next = next.next;
        //pNode = pNode.next;这样只是在修改pNode实例引用的拷贝，对原有的pNode没有影响
        if(pNode.next == null){
            last.val = pNode.val;
        }
        return true;
    }
}

public class _07_CatDogAsylum_fail {

    public static ArrayList<Integer> asylum(int[][] ope) {
        QueueAsyum catDogAsyum = new QueueAsyum();
    	ArrayList<Integer> result = new ArrayList<>();
        int catIndex; //查找的猫/狗的序号，0代表没有找到
    	for (int i = 0; i < ope.length; i++) {
    		switch (ope[i][0]) {
    			case 1:
    				catDogAsyum.enqueue(ope[i][1]);
    			break;
    			case 2:
                    if (ope[i][1] == 0) {
                        result.add(catDogAsyum.dequeue());
                    } else if (ope[i][1] == 1) {
                        catIndex = catDogAsyum.dequeueDog();
                        if (catIndex != 0) {
                            result.add(catIndex);
                        }
                    } else if (ope[i][1] == -1) {
                        catIndex = catDogAsyum.dequequeCat();
                        if (catIndex != 0) {
                            result.add(catIndex);
                        }
                    }
    			break;
    			default:
    				System.exit(-1);
    			break;
    		}
    	}
    	return result;
    }

    public static void main(String[] args) {
        int[][] ope = {{1,-3},{1,-6},{1,10},{1,3},{2,0},{1,19},{2,-1},{1,-81},{1,36},{2,0},{2,1},{1,66},{2,0},{1,-13},{2,0},{2,-1},{2,0},{1,29},{2,1},{2,1},{2,1},{1,56},{1,-99},{2,-1},{2,-1},{1,79},{1,-25},{1,-6},{1,63},{1,48},{1,-40},{1,56},{2,1},{1,28},{1,78},{1,20},{1,18},{1,20},{1,-92},{1,87},{2,0},{1,34},{2,-1},{1,96},{1,38},{2,0},{2,-1},{1,17},{1,13},{1,3},{1,-26},{2,0},{2,0},{2,-1},{2,1},{2,0},{1,-78},{1,57},{1,71},{1,-11},{2,-1},{1,-28},{1,-28},{1,-87},{1,-86},{1,-9},{1,50},{2,1},{2,0},{1,65},{1,-98},{1,-54},{2,0},{2,-1},{1,84},{1,-72},{1,-42},{1,77},{1,-61},{1,-61},{1,-11},{1,94},{2,1},{1,93},{2,-1},{2,-1},{1,43},{2,-1},{1,-72},{2,-1},{1,-31},{1,-41},{1,-85},{1,-2},{2,0},{1,94},{1,80},{1,-86},{1,-83},{1,-20},{1,49},{1,-47},{1,46},{1,34},{2,1},{2,0},{1,-41},{2,1},{2,-1},{1,-44},{1,100},{1,-85},{1,-25},{1,-8},{1,-69},{1,13},{1,82},{2,1},{1,-41},{1,-44},{1,22},{1,-72},{1,-16},{1,-11},{1,65},{1,-66},{1,25},{1,-31},{1,-63},{2,1},{1,86},{1,2},{1,6},{1,-42},{1,-9},{1,76},{1,54},{2,0},{2,1}};
        ArrayList<Integer> result = asylum(ope);
        System.out.println(result);
    }
}



