package _04_tree_graph;
import java.util.*;

/*
public class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}*/
public class _02_checkPath {
    //注意题目中说的是无向图！这和坐链表问题前搞明白到底是双向链表还是单向链表类似，很重要！
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        if (a == null || b == null) {
            return false;
        }
        return findPath(a, b) || findPath(b, a);

    }

    public static boolean findPath (UndirectedGraphNode a, UndirectedGraphNode b){
        HashSet<UndirectedGraphNode> hashSet = new HashSet<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            //逻辑要清楚，这里要做的是取出队列中的节点并进！行！比！对！，弄明白你的逻辑
            //并把逻辑反应到代码，知道代码的每一行都在干什么
            UndirectedGraphNode node = queue.removeFirst();
            if (node == b) {
                return true;
            }
            hashSet.add(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode item = node.neighbors.get(i);
                if (!hashSet.contains(item)) {
                    queue.addLast(item);
                }
            }
        }
        return false;
    }
}