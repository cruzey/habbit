package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11724 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] visited;    
    static int result = 0;    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        for (int i = 1; i < visited.length; i++) {
            if(visited[i] == false) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i < N + 1; i++) {
            if(arr[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
