package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11054 {
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken()); 
        }

        //dp[i] = A[i]를 기준으로 가장 긴 바이토닉 수열의 길이
        //dp[1] = A[1] = 1
        //dp[2] = 
        int[] dp_L = new int[N + 1];
        int[] dp_R = new int[N + 1];

        for (int i = 1; i < N+ 1; i++) {
            dp_L[i] = 1;
            dp_R[i] = 1;
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j]) {
                    dp_L[i] = Math.max(dp_L[i], dp_L[j] + 1);
                }
            }
        }

        for (int i = N; i >= 1; i--) { // 거꾸로 출발!
            for (int j = N; j > i; j--) { // 내 오른쪽 끝부터 내 앞까지 훑기
                // A[i]가 내 오른쪽 숫자들보다 크면 오름차순 인정!
                if (A[i] > A[j]) {
                    dp_R[i] = Math.max(dp_R[i], dp_R[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int length = dp_L[i] + dp_R[i] - 1;
            result = Math.max(result, length);
        }

        System.out.println(result);
    }
}
