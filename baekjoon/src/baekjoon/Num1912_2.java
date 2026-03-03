package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1912_2 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //dp[i] 를 마지막 원소로 하는 연속된 최대 합
        int[] dp = new int[n + 1];
        
        dp[1] = arr[1];

        int result = dp[1];

        for (int i = 1; i < n + 1; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
