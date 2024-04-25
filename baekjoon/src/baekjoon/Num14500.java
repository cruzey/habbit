package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14500 {

    static int N, M;
    static int[][] board;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        // board is ready
        setUp();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] =true;
                dfs(i, j, 0, board[i][j]);
                visited[i][j] =false;
            }
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int cnt, int temp) {

        if (cnt == 3) {
            result = Math.max(result, temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(visited[nx][ny] == false){
                    if(cnt == 1){
                        visited[nx][ny] = true;
                        dfs(x, y, cnt+1, temp + board[nx][ny]);
                        visited[nx][ny] = false;
                    }
                    visited[nx][ny] = true;
                    dfs(nx, ny, cnt+1, temp + board[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }

    }

    static void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
    }
}
