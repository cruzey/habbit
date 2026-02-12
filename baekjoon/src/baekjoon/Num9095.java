package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num9095 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solve(n)).append("\n");
        }

        System.out.println(sb);
    }

    static int solve (int n) {
        int[] dp = new int[11];
        //dp[n] = 정수 n을 1, 2, 3의 합으로 나타내는 경우의 수
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1+1, 2
        dp[3] = 4;  // 1+1+1, 2+1, 1+2, 3
        //dp[n] = dp[n-1] + dp[n-2] + dp[n-3]

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
        
    }

}
