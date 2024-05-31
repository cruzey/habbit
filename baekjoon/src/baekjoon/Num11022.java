package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11022 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st;
        int a, b;
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            a = Integer.parseInt(st[0]);
            b = Integer.parseInt(st[1]);

            System.out.printf("Case #%d: %d + %d = %d%n", i+1, a, b, a+b);

        }

    }
}
