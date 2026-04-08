package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2146_2 {
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

        for (int i = 2; i < numOfIsland; i++) { 
            // i번 섬에서 타국으로 가는 최단 거리 찾기
            result = Math.min(findRoute(i), result); 
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

    static int findRoute(int numOfIsland) {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N][N]; // 여기서 딱 한 번만 도화지를 새로 깝니다.
    
        // 🌟 [핵심] 지도 전체를 뒤져서 '지금 출발할 섬'의 땅을 몽땅 큐에 넣습니다! (토마토 방식)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == numOfIsland) {
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0)); // 거리 0으로 몽땅 투입!
                }
            }
        }

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
