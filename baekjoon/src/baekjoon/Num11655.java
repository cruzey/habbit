package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num11655 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            sb.append(ROT13(c));
        }

        System.out.println(sb);
    }

    static char ROT13(char c) {
        if (c >= 'a' && c <= 'z') {
            // 'a'를 빼서 0~25로 만든 뒤 13을 더하고, 26으로 나눈 나머지에 다시 'a'를 더함
            return (char) ((c - 'a' + 13) % 26 + 'a');
        } else if (c >= 'A' && c <= 'Z') { // 대문자 확인
            return (char) ((c - 'A' + 13) % 26 + 'A');
        } else {
            return c; 
        }
    }
}
