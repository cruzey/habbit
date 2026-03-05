package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1932 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n + 1][n + 1];
        StringTokenizer st;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i + 1; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + tri[i][j], dp[i - 1][j] + tri[i][j]); 
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);

    }
}
