package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num1699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        // 1부터 N까지 채워나갑니다.
        for (int i = 1; i <= N; i++) {
            
            // 초기값 세팅: 최악의 경우는 1의 제곱(1)으로만 i를 채우는 것입니다. (개수는 i개)
            dp[i] = i; 

            // i보다 작거나 같은 모든 제곱수(j * j)를 빼보면서 최솟값을 찾습니다!
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}