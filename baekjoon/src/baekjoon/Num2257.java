package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num2257 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < st.length(); i++) {
            Character c = st.charAt(i);
            if (c == 'C') {
                stack.push(12);
            }else if (c == 'H') {
                stack.push(1);
            }else if (c == 'O') {
                stack.push(16);
            }else if (c == '(') {
                stack.push(-1);
            }else if (c == ')') {
                int num = 0;
                while (stack.peek() != -1) {
                    num = num + stack.pop();
                }
                stack.pop();
                stack.push(num);
            }else if (Character.isDigit(c)) {
                int num = stack.pop() * Integer.parseInt(c.toString());
                stack.push(num); 
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
