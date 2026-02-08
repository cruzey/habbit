package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num10808 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        for (int i = 97; i < 123; i++) {
            int cnt = 0;
            for (int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                
                if (i == (int)c) {
                    cnt++;
                }

            }
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);

    }
}
