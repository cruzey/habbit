package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num1463 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0; // 1은 이미 1이므로 연산 0번

        for (int i = 2; i <= N; i++) {
            // 1. 일단 1을 빼는 경우 (항상 가능)
            dp[i] = dp[i - 1] + 1;

            // 2. 2로 나누어 떨어지는 경우, 1을 뺀 경우와 비교해서 더 작은 값 선택
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            // 3. 3으로 나누어 떨어지는 경우, 현재까지의 최솟값과 비교
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[N]);
    }
}
