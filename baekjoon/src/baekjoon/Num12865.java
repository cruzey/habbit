package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num12865 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 물품의 수
        int N = Integer.parseInt(st.nextToken());
        // 최대 무게
        int K = Integer.parseInt(st.nextToken());
        // 물건 배열
        Stuff[] arr = new Stuff[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Stuff(w, v);
        }

        // dp[][0] = 무게
        // dp[][1] = 가치
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                // 지금까지의 무게 + 현재 물건 무게 <= 최대 무게
                if(dp[j][0] + arr[i].getW() <= K && dp[j][1] + arr[i].getV() > dp[i][1]) {
                    dp[i][0] += arr[i].getW();
                    dp[i][1] = dp[j][1] + arr[i].getV();
                }     
            }    
        }

        int result = 0;
        for (int[] is : dp) {
            result = Math.max(is[1], result);
        }

        System.out.println(result);

    }

    static class Stuff {
        int W;  // 무게
        int V;  // 가치

        public Stuff() {}

        public Stuff(int w, int v) {
            this.W = w;
            this.V = v;
        }

        public int getV() {
            return V;
        }

        public int getW() {
            return W;
        }

        public void setV(int v) {
            V = v;
        }

        public void setW(int w) {
            W = w;
        }
    }
}
