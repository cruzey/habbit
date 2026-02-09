package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num10809 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int target = arr[c-97];

            if(target == -1) arr[c-97] = i;
            else continue;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
