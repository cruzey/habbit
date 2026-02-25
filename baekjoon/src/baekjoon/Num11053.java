package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11053 {
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < A + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        int[] dp = new int[A + 1];
        
        for (int i = 1; i < A + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i < A + 1; i++) {
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            if(i > result) result = i;
        }
        
        System.out.println(result);
    }
}
