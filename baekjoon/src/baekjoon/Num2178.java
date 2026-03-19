package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2178 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] resultMap;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N + 1][M + 1];
        resultMap = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            // st = new StringTokenizer(br.readLine(), "");
            char[] c = br.readLine().toCharArray();

            for (int j = 1; j < M + 1; j++) {
                Character target = c[j - 1];
                map[i][j] = Integer.parseInt(target.toString());
                // map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1, 1);
        System.out.println(resultMap[N][M]);
    }

    static void bfs(int n, int m) {
        int[] dy = {-1, 1, 0 ,0};
        int[] dx = {0, 0, -1 ,1};

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {n, m});
        visited[n][m] = true;
        resultMap[n][m] = 1;

        while (!q.isEmpty()) {
            int[] val = q.poll();
            int y = val[0];
            int x = val[1];

            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];

                if(newY < 1 || newX < 1 || newY > N || newX > M) continue;

                if(map[newY][newX] != 0 && !visited[newY][newX]) {
                    q.add(new int[] {newY, newX});
                    visited[newY][newX] = true;
                    resultMap[newY][newX] = resultMap[y][x] + 1;
                }
            }

        }
    }
}
