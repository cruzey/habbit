package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11722 {
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken()); 
        }

        //dp[i] = A[i]를 기준으로 하는 가장 긴 감소하는 부분 수열의 길이
        int[] dp = new int[N + 1];
            
        for (int i = N; i >= 1; i--) {
            dp[i] = 1;
            for (int j = N; j > i; j--) {
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(result, i);
        }

        System.out.println(result);

    }
}
