package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num11727 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        // dp[n] = 2 * n 크기의 직사각형을 2 * 1 크기 블럭으로 채우는 경우의 수
        // ex) dp[1] = 1, dp[2] = 3, dp[3] = 5, dp[4] = 11, ...
        // 점화식 dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 2]

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
