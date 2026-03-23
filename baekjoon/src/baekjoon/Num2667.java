package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(); 

        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = c[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    list.add(dfs(i, j, 1));
                }
            }
        }

        Collections.sort(list);
        
        System.out.println(list.size());
        for (Integer cnt : list) {
            System.out.println(cnt);
        }
    }

    static int dfs(int y, int x, int count) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            //범위 out
            if(newY < 0 || newY >= N || newX < 0 || newX >= N) continue;
            //집이 없거나, 방문한 집이면 out
            if (map[newY][newX] == 0 || visited[newY][newX]) continue;

            count += dfs(newY, newX, 1);
        }
        
        return count;
    }
}
