package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num10820 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s;

        while ((s = br.readLine()) != null) {

            int big = 0;
            int small = 0;
            int num = 0;
            int blank = 0;

            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z'){
                    small++;
                } else if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'){
                    big++;
                } else if(s.charAt(j) == ' '){
                    blank++;
                } else if(s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                    num++;
                }
            }

            sb.append(small).append(" ").append(big).append(" ").append(num).append(" ").append(blank).append("\n");
        }

        System.out.println(sb);
    }
}
