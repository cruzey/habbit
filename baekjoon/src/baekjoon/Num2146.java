package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 초기화
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맵에 각 섬 별로 구분짓기
        visited = new boolean[N][N];
        int numOfIsland = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    countIsland(new Node(i, j), numOfIsland);
                    numOfIsland++;
                }
            }
        }

        // 섬에서 바다로 거리 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 내가 섬이라면
                if(map[i][j] != 0) {
                    visited = new boolean[N][N];
                    result = Math.min(findRoute(new Node(i, j, 0)), result);
                }
            }
        }

        System.out.println(result);
    }

    // 섬 표기
    static void countIsland(Node node, int numOfIsland) {
        Queue<Node> q = new LinkedList<>();
        visited[node.y][node.x] = true;
        map[node.y][node.x] = numOfIsland;
        q.add(node);

        while (!q.isEmpty()) {
            Node island = q.poll();
            int y = island.y;
            int x = island.x;

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if(nY < 0 || nY >= N || nX < 0 || nX >= N) continue;
                if(visited[nY][nX] == true) continue;
                if(map[nY][nX] == 1) {
                    visited[nY][nX] = true;
                    map[nY][nX] = numOfIsland;
                    q.add(new Node(nY, nX));
                }
            }
        }
    }

    static int findRoute(Node node) {
        Queue<Node> q = new LinkedList<>();
        int numOfIsland = map[node.y][node.x];
        q.add(node);

        while (!q.isEmpty()) {
            Node island = q.poll();
            int y = island.y;
            int x = island.x;
            int dist = island.dist;

            for (int i = 0; i < 4; i++) {
                int nY = y + dy[i];
                int nX = x + dx[i];

                if(nY < 0 || nY >= N || nX < 0 || nX >= N) continue;
                if(visited[nY][nX] == true) continue;
                // 바다라면
                if(map[nY][nX] == 0) {
                    visited[nY][nX] = true;
                    q.add(new Node(nY, nX, dist + 1));
                } 
                // 다른 섬이라면
                else if(map[nY][nX] != numOfIsland){
                    return dist;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
