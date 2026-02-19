package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num11057 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solve(N));

    }

    static int solve (int N) {

        int[][] dp = new int[N+1][10];
        //dp[N] = 길이가 N인 오르막 수의 개수
        //dp[1][j] = 10, dp[2][j] = 55
        //dp[i][j] = dp[i-1][0....j]

        //dp[1][0...9] 0으로 초기화
        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
                }
            }
        }

        int result = 0;
        for (int j = 0; j < 10; j++) {
            result = (result + dp[N][j]) % 10007;
        }

        return result;
    }
}
