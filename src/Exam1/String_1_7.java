import java.lang.System;
import java.util.*;
import java.util.Scanner;

public class String_1_7 {
    public static int[][] clearZero(int[][] mat, int n) {
        for (int i = 0; i < mat.length ; i++) {
        	for (int j = 0; j < mat[i].length ; j++) {
        		if(mat[i][j] == 0){
        			//清除对应的每一行
        			for (int k = 0; k < mat[i].length; k++) {
        				mat[i][k] = 0;
        			}
        			//清除对应的每一列
        			for (int m = 0; m < mat.length; m++) {
        				mat[m][j] = 0;
        			}
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