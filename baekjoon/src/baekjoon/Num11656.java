package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num11656 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String[] arr = new String[S.length()];

        for (int i = 0; i < S.length(); i++) {
            arr[i] = S.substring(i, S.length());
        }

        Arrays.sort(arr);

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}
