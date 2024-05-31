package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11720 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int result = 0;
        String[] st = br.readLine().split("");
        
        for (int i = 0; i < st.length; i++) {
            result += Integer.parseInt(st[i]);
        }
        System.out.println(result);
    }
}
