package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num10799_2 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> st = new Stack<>();

        int result = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else{
                if(s.charAt(i - 1) == '('){ // 레이저
                    st.pop();
                    result += st.size();
                }else{  // 쇠막대기
                    st.pop();
                    result++;
                }
            }
        }

        System.out.print(result);
    }
}
