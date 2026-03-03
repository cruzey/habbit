package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1912 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp[i] = 길이가 i인 배열의 원소들의 연속된 값의 합 중 최대

        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = arr[i];
        }

        for (int i = 1; i < n + 1; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }

        int result = dp[1];
        for (int i = 2; i < n + 1; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
