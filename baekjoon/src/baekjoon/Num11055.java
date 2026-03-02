package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11055 {
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken()); 
        }

        //dp[i] = A[i]를 기준으로 하는 가장 큰 증가 부분 수열의 합
        int[] dp = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i] = A[i];
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (A[i] > A[j]) {
                    // 기존에 가지고 있던 내 합(dp[i])과,
                    // 과거의 합(dp[j])에 내 숫자(A[i])를 더한 값 중 더 큰 것을 선택!
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}
