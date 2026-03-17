package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2606_bfs {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int result = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        
        StringTokenizer st = null;
        arr = new int[n + 1][n + 1]; 
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[n + 1];
        bfs(1);

        System.out.println(result);

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i = 1; i < n + 1; i++) {
                if (arr[t][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    result++;
                }
            }
        }
    }
}
