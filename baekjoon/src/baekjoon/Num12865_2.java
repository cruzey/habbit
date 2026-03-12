package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num12865_2 {
    
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

        // dp[i][w] = i번째 물건까지 고려했고, 배낭 용량이 w일 때의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 1번 물건부터 N번 물건까지 하나씩 가방에 넣어볼까 고민합니다.
        for (int i = 1; i <= N; i++) {
            // 배낭의 허용 무게(w)를 1부터 K까지 늘려가면서 표를 채웁니다.
            for (int w = 1; w <= K; w++) {
                
                // 1. 현재 물건의 무게가 배낭의 허용 무게(w)보다 크면 못 넣음!
                if (arr[i].getW() > w) {
                    dp[i][w] = dp[i - 1][w]; // 과거의 영광을 그대로 가져옴
                } 
                // 2. 넣을 수 있다면? (안 넣은 것 vs 내 무게만큼 비워둔 과거 + 내 가치) 중 최대!
                else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - arr[i].getW()] + arr[i].getV());
                }
            }
        }

        // 모든 물건(N)을 살펴보고, 배낭 용량이 K일 때의 값이 최종 정답!
        System.out.println(dp[N][K]);

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
