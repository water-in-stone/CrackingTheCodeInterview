import java.util.*;

public class _10_getHeight {

    class SimpleBox {
        int w;
        int l;
        int h;
        public SimpleBox(int x, int y, int z) {
            w = x;
            l = y;
            h = z;
        }
    }

    private class BoxComparator implements Comparator < SimpleBox > {

        public int compare(SimpleBox a, SimpleBox b) {
            return b.w - a.w;
        }
    }

    public int getHeight(int[] w, int[] l, int[] h, int n) {

        if (w == null || l == null || h == null || n == 0) return 0;

        List < SimpleBox > list = new ArrayList < SimpleBox > ();
        for (int i = 0; i < n; i++) {
            SimpleBox b = new SimpleBox(w[i], l[i], h[i]);
            list.add(b);
        }
        Collections.sort(list, new BoxComparator()); // 按宽度降序排列
        int max = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = list.get(i).h;
            int temp = 0; // 找出前面的最大高度
            for (int j = 0; j < i; j++) {
                if (list.get(j).l > list.get(i).l) { //w宽度已经有序： 前面的宽度>后面的宽度              
                    temp = Math.max(f[j], temp);
                }
            }
            f[i] += temp; // 把i叠上去后的高度
            max = Math.max(max, f[i]);
        }

        return max;
    }
}