package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num10808_2 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        
        String S = br.readLine();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            arr[c-97]++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
