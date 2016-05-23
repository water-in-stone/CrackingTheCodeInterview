package _17_middle_question;

import java.util.*;

public class _02_Board{

	public static void main(String[] args) {
		int[][] board = {{1,0,1},{1,-1,-1},{1,-1,0}};
		System.out.println(checkWon(board));
	}

	public static boolean checkWon(int[][] board) {
		int n = board.length;
		if (judgeDiagonal(board)) {
			return true;
		}
		for (int i = 0; i < n; i++) {
			if (judgeRow(board, i) || judgeCol(board, i)) {
				return true;
			}
				
		}
		return false;
    }

    public static boolean judgeRow(int[][] board, int row){
    	for (int i = 0; i < board.length; i++) {
    		if(board[row][i] != 1){
    			return false;
    		}
    	}
    	return true;
    }

    public static boolean judgeCol(int[][] board, int col){
    	for (int i = 0; i < board.length; i++) {
    		if(board[i][col] != 1){
    			return false;
    		}
    	}
    	return true;
    }

    public static boolean judgeDiagonal(int[][] board){
    	int n = board.length;
    	boolean flag = true;
    	//check one diagonal
    	for (int i = 0; i < n; i++) {
    		if (board[i][i] != 1) {
    			flag = false;
    			break;
    		}
    	}
    	if (flag) {
    		return true;
    	}
    	//init flag to check another diagonal
    	flag = true;
    	for (int i = n - 1; i >= 0; i--) {
    		if (board[n - 1 - i][i] != 1) {
    			flag = false;
    			break;
    		}
    	}
    	return flag;
    }
}
