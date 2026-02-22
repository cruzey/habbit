package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num2193 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //dp[N][0] = 0으로 끝나는 N자리 이친수의 개수, dp[N][1] = 1로 끝나는 N자리 이친수의 개수
        //dp[1][0] = 0, dp[1][1] = 1
        //dp[2][0] = 1, dp[2][1] = 0
        //dp[3][0] = 1, dp[3][1] = 1
        //dp[N][0] = dp[N - 1][0] + dp[N - 1][1], dp[N][1] = dp[N - 1][0]
        
        //알고보니 피보나치 였네,,,,,,
        //dp[N] = dp[N - 1] + dp[N - 2],,,,
        //dp[N - 1] 뒤에 0 붙이는 경우의 수 + dp[N - 2] 뒤에 01 붙이는 경우의 수,,,

        long[][] dp = new long[N + 1][2];
        
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        long result = 0;

        for (int i = 0; i < 2; i++) {
            result += dp[N][i];
        }
        
        System.out.println(result);

    }
}
