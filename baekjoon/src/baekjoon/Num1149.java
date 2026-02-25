package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1149 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            house[i][0] = Integer.parseInt(st.nextToken()); // R
            house[i][1] = Integer.parseInt(st.nextToken()); // G
            house[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        //1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        // N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        // i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

        //dp[N] = 모든 집을 색칠하는 비용의 최솟값
        //dp[i][0] = min(dp[i - 1][1],  dp[i - 1][2] + house[i][0])
        
        int[][] dp = new int[N + 1][3];

        //초기화
        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for (int i = 2; i < N + 1; i++) {
            int R = dp[i - 1][0];
            int G = dp[i - 1][1];
            int B = dp[i - 1][2];

            dp[i][0] = Math.min(G, B) + house[i][0];
            dp[i][1] = Math.min(R, B) + house[i][1];
            dp[i][2] = Math.min(R, G) + house[i][2];

        }

        int tmp = Math.min(dp[N][0], dp[N][1]);
        System.out.println(Math.min(dp[N][2], tmp));
    }
}
