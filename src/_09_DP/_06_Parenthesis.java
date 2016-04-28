package _09_DP;
import java.util.*;

public class _06_Parenthesis{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt() * 2;
			boolean[] visited = new boolean[n];
			ArrayList<String> result = new ArrayList<>();
			String brackets = "";
            for (int i = 0; i < n / 2; i++) {
				brackets += "(";
			}
			for (int j = 0; j < n / 2; j++) {
				brackets += ")";
			}
			printParenthesis(result, "", n, visited, brackets);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
		sc.close();
	}


	/**
	 * use backtracking to create all permutation of brackets
	 */
	public static void printParenthesis(ArrayList<String> result, String str, int n, boolean[] visited, String brackets) {
        if (str.length() == n && checkPermutation(str) && !result.contains(str)) {
        	result.add(str);
        } else {
        	for (int i = 0; i < brackets.length(); i++) {
        		if (!visited[i]) {
        			visited[i] = true;
        			String nextStr = str + brackets.charAt(i); //new permutation
        			printParenthesis(result, nextStr, n, visited, brackets);
        			visited[i] = false;
        		}
        	}
        }
    }

    /**
     * check the validity of permutation, using stack
     */
    
    public static boolean checkPermutation(String s){
    	LinkedList<Character> stack = new LinkedList<>();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			stack.push('(');
    		} else if(s.charAt(i) == ')' && !stack.isEmpty()){
    			stack.pop();
    		} else {
				return false;    			
    		}
    	}
    	return true;
    }
}
