package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1707 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V;
    static int E;
    static ArrayList<Integer>[] list;
    static int[] colors;

    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());
            
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            sb.append(solve(V, E)).append("\n");
        }

        System.out.println(sb);
    }

    static String solve(int V, int E) throws IOException {
        list = new ArrayList[V + 1];
        colors = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>(); // 리스트 초기화
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        // 끊어진 덩어리들을 모두 확인합니다.
        for (int i = 1; i <= V; i++) {
            if (colors[i] == 0) {
                // 청팀(1)으로 탐색 시작! 근데 쪼개진 덩어리 중 하나라도 실패하면 전체가 NO!
                if (!dfs(i, 1)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    static boolean dfs(int node, int color) {
        colors[node] = color; // 내 색깔 칠하기!

        for(int next : list[node]) {
            // 1. 이미 방문했는데, 하필 나랑 색이 똑같다?! 👉 이분 그래프 아님!
            if (colors[next] == color) {
                return false;
            }
            
            // 2. 아직 방문 안 했다면? 👉 반대 색깔(-color)로 탐색 출발!
            if (colors[next] == 0) {
                // 탐색 보낸 곳에서 에러(false)가 터져서 돌아오면, 나도 즉시 false 반환!
                if (!dfs(next, -color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
