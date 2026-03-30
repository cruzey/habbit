package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Num10026 {
    static boolean[][] visited;
    static char[][] map;
    static int N;
    static int result1 = 0;
    static int result2 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] col = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = col[j];
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result1++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    static void bfs(int row, int column) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, column});
        visited[row][column] = true;
        
        while (!q.isEmpty()) {
            int[] target = q.poll();

            int y = target[0];
            int x = target[1];

            char currentColor = map[y][x];

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if(nY < 0 || nY >= N || nX < 0 || nX >= N) continue;
                if(visited[nY][nX]) continue;

                if(map[nY][nX] == currentColor) {
                    q.add(new int[] {nY, nX});
                    visited[nY][nX] = true;
                }
            }
        }

    }
}
