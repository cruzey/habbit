package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.management.StringValueExp;

public class Num2557 {

    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < st.length(); i++) {
			Character ch = st.charAt(i);
			if (ch == 'C') {
				stack.add(12);
			} else if (ch == 'O') {
				stack.add(16);
			} else if (ch == 'H') {
				stack.add(1);
			} else if (Character.isDigit(ch)) {
				int num = stack.pop();
				stack.add(num * Integer.parseInt(ch.toString()));
			} else if (ch == '(') {
				stack.add(-1);
			} else if (ch == ')') {
				int num = 0;
				while (stack.peek() != -1) {
					num += stack.pop();
				}
				stack.pop();
				stack.add(num);
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		System.out.println(result);
        
    }
}
