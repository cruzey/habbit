package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num2156 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        //dp[n] = n개의 와인 중 삼연속적이지 않으면서 최대로 먹을 수 있는 경우의 수
        //dp[1] = wine[1]
        //dp[2] = wine[1] + wine[2]
        //dp[3] = max(wine[2] + wine[3], dp[1] + wine[3], dp[2])
        //dp[4] = max(dp[1] + wine[3] + wine[4], dp[2] + wine[4], dp[3])
        //dp[i] = max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i], dp[i - 1])

        int[] dp = new int[n + 1];
        
        //초기화
        dp[1] = wine[1];
        if(n > 1) dp[2] = wine[1] + wine[2];

        for (int i = 3; i < n + 1; i++) {
            int tmp = Math.max(dp[i - 2] + wine[i], dp[i - 1]);
            dp[i] = Math.max(dp[i - 3] + wine[i - 1] + wine[i], tmp);
        }

        System.out.println(dp[n]);

    }
}
