package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num9012_2 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(solve(br.readLine())).append("\n");
        }

        System.out.println(sb);

    }

    public static String solve(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '('){
                st.push(c);
            }else if (st.empty()){
                return "NO";
            }else{
                st.pop();
            }
        }

        if(st.empty()) return "YES";
        else return "NO";
    }
}
    