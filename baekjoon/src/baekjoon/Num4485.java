package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num4485 {
    static int N;
    static int[][] cave;
    static int[][] dist;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int cnt = 1;
        while (N != 0) {
            legendOfZelda();
            sb.append("Problem ").append(cnt).append(": ").append(dist[N - 1][N - 1]).append("\n");    
            N = Integer.parseInt(br.readLine());
            cnt++;
        }

        System.out.println(sb);
    }

    static void legendOfZelda() throws IOException {
        // 초기화
        cave = new int[N][N];
        dist = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                cave[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dijkstra();
    }

    static void dijkstra() {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        PriorityQueue<BlackRupee> pq = new PriorityQueue<>((a, b) -> a.k - b.k);
        //시작점의 가격
        dist[0][0] = cave[0][0];
        pq.add(new BlackRupee(0, 0, cave[0][0]));

        while (!pq.isEmpty()) {
            BlackRupee bRupee = pq.poll();
            int y = bRupee.y;
            int x = bRupee.x;
            int k = bRupee.k;

            if(dist[y][x] < bRupee.k) continue;

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if(nY < 0 || nY >= N || nX < 0 || nX >= N) continue;

                int nK = cave[nY][nX];
                int totalK = bRupee.k + nK;

                if(dist[nY][nX] > totalK) {
                    dist[nY][nX] = totalK;
                    pq.add(new BlackRupee(nY, nX, totalK));
                }
            }
            
        }

    }

    static class BlackRupee {
        int y;
        int x;
        int k;

        public BlackRupee(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }
}
