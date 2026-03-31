package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num14502 {
    static int N;   // row
    static int M;   // column
    static int[][] map;
    static int[][] virusMap;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int cnt) {
        // 벽 3개를 다 세운 후
        if (cnt == 3) {
            bfs();
            return;
        }
        // 벽 세우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    
                    // 백 트래킹
                    map[i][j] = 1;     // [행동] 벽을 세운다!
                    dfs(cnt + 1);      // [재귀] 다음 벽 세우러 보낸다! (cnt++ 절대 금지)
                    map[i][j] = 0;     // 💥 [되돌리기] 탐색 다 하고 돌아오면 벽을 다시 허문다!!
                    
                }
            }
        }

        // 반복문의 시작점을 현재 내 위치(y, x)부터 시작하게 조정!
        // 이렇게 변경하면 중복 탐색이 사라진다
        // ex) (0, 3) 에 벽을 세우고 재귀하면 다시 (0, 1)에 벽을 세울 수 있음, 그건 이미 (0, 1)로 시작할 때 탐색한 경우의 수이기 때문,
        // 따라서 행이 바뀌지 않았다면, 탐색한 좌표의 col값을 이어서 탐색하도록 수정
        
        // for (int i = y; i < N; i++) {
        //     // 행(i)이 바뀌면 열은 다시 0부터, 같은 행이면 현재 x부터!
        //     for (int j = (i == y ? x : 0); j < M; j++) { 
        //         if (map[i][j] == 0) {
        //             map[i][j] = 1;
        //             dfs(i, j, cnt + 1); // 다음 벽은 지금 내 위치 이후부터 찾아!
        //             map[i][j] = 0;
        //         }
        //     }
        // }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>(); 
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        virusMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] target = q.poll();
            int y = target[0];
            int x = target[1];

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if(nY < 0 || nY >= N ||nX < 0 || nX >= M) continue;
                // 빈 칸이라면 감염
                if (virusMap[nY][nX] == 0) {
                    virusMap[nY][nX] = 2;
                    q.add(new int[] {nY, nX});
                }
            }
        }

        result = Math.max(result, countSafeZone(virusMap));
    }

    static int countSafeZone(int[][] virusMap) {
        int sfzCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(virusMap[i][j] == 0) sfzCount++;
            }
        }

        return sfzCount;
    }
}
