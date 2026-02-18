package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num10844 {

    static final long MOD = 1000000000;
    
    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solve(N));

    }

    static long solve (int N) {
        //인접한 모든 수의 차이가 1인 수
        //dp[i][j] = 길이가 i이면서, 마지막 숫자가 j인 계단 수의 개수
        //dp[N][0] = dp[N-1][1]
        //dp[N][5] = dp[N-1][4] + dp[N-1][6]
        long[][] dp = new long[N + 1][10];

        // 2. 초기값 설정 (길이가 1일 때, 1~9는 각각 1개)
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 3. DP 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) { // j 범위를 0~9까지 확실하게
                
                // 마지막 자리가 0이면, 이전 자리는 1만 가능
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % MOD;
                }
                // 마지막 자리가 9면, 이전 자리는 8만 가능
                else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                }
                // 그 외(1~8)는 이전 자리가 j-1 또는 j+1 가능
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        // 4. 결과 출력 (N번째 줄의 합만 구하기)
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        return result;

    }
}
