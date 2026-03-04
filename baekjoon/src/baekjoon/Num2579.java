package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num2579 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());    
        }

        //dp[i] = i개의 계단의 총 합 중 최댓값
        //dp[i] = dp[i - 1] + stair[i], dp[i - 2] + stair[i]
        int[] dp = new int[n + 1];

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        for (int i = 3; i < n + 1; i++) {
            dp[i]= Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }

        System.out.println(dp[n]);
    }
}
