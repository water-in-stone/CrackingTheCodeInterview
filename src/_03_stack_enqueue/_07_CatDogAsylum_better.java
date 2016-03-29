package _03_stack_enqueue;

import java.util.*;

/**
 * Created by Young on 2016/3/29.
 * wang645788@gmail.com
 */
public class _07_CatDogAsylum_better {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> r = new ArrayList<>();// 存放最终收养序列
        ArrayList<Integer> animal = new ArrayList<>();// 存放进入收容所的动物
        int temp = 0;
        for (int i = 0; i < ope.length; i++) {
            switch (ope[i][0]) {
                // 有动物进入收容所
                case 1:
                    animal.add(ope[i][1]);
                    break;
                // 有人收养动物
                case 2:
                    // 第一种收养方式
                    if (!animal.isEmpty() && ope[i][1] == 0) {
                        r.add(animal.get(0));
                        animal.remove(0);
                    }
                    // 收养狗
                    else if (ope[i][1] == 1) {
                        for (temp = 0; temp < animal.size(); temp++) {
                            if (animal.get(temp) > 0) {
                                r.add(animal.get(temp));
                                animal.remove(temp);
                                break;
                            }
                        }
                    }
                    // 收养猫
                    else if (ope[i][1] == -1) {
                        for (temp = 0; temp < animal.size(); temp++) {
                            if (animal.get(temp) > 0) {
                                r.add(animal.get(temp));
                                animal.remove(temp);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return r;
    }
}
