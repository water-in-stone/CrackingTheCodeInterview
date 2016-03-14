package exam_string_1;

import java.lang.System;
import java.util.*;
import java.util.Scanner;

public class String_1_7 {
    public static int[][] clearZero(int[][] mat, int n) {
        //引入一个相同大小的标记矩阵来进行清零的操作
        int[][] matFlag = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length ; i++) {
        	for (int j = 0; j < mat[i].length ; j++) {
        		if(mat[i][j] == 0){
        			//将标记矩阵中对应的那一行给置为1
        			for (int k = 0; k < mat[i].length; k++) {
        				matFlag[i][k] = 1;
        			}
        			//将标记矩阵中对应的那一列给置为1
        			for (int m = 0; m < mat.length; m++) {
                        matFlag[m][j] = 1;
        			}
        		}
        	}
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(matFlag[i][j] == 1){
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
    public static void main(String[] args) {
		int[][] mat = {{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
		mat = clearZero(mat, 3);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
    }
}