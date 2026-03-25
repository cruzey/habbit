package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1707_bfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;
    static int[] divided;
    
    public static void main(String[] args) throws Exception {
        // TC 개수
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(solve(V, E)).append("\n");
        }

        System.out.println(sb);
    }

    static String solve(int V, int E) throws Exception {
        list = new ArrayList[V + 1];
        divided = new int[V + 1];

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

        for (int i = 1; i <= V; i++) {
            if (divided[i] == 0) {
                if(!bfs(i)) return "NO";
            }
        }

        return "YES";
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        divided[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int val = q.poll();
            
            for (int tar : list[val]) {
                if(divided[tar] == divided[val]) return false;
                if(divided[tar] == 0) {
                    divided[tar] = -divided[val];
                    q.add(tar);
                }
            }
        }

        return true;
    }
}
