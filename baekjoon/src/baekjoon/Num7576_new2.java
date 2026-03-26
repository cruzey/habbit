package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// visited가 필요없었다,, 익지 않은 토마토가 자동으로 방문한 적 없는 좌표를 나타내기 때문
public class Num7576_new2 {
    static int N;                   // row
    static int M;                   // column
    static int[][] map;             // 토마토 상자
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        // 초기화
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) { 
                    q.add(new int[] {i, j});
                }
            }
        }
        //이미 1인 익은 토마토는 모두 q에 들어간 상태
        bfs();

        for (int[] rows : map) {
            for (int column : rows) {
                // 창고에 0이 하나라도 남아있다면
                if (column == 0) { 
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, column);                
            }
        }
        System.out.println(result - 1);
    }

    static void bfs() {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1}; 

        while (!q.isEmpty()) {

            int[] point = q.poll();
            int y = point[0];
            int x = point[1];

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                // 새 좌표가 map을 벗어나면, 이미 방문한 좌표라면 패스
                if(nY < 0 || nY >= N || nX < 0 || nX >= M) continue;

                // 방문한 좌표가 익지않은 토마토라면
                if(map[nY][nX] == 0) {
                    map[nY][nX] = map[y][x] + 1;
                    q.add(new int[] {nY, nX});
                }
            }

        }
    }
}
