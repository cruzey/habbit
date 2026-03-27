package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10451_2 {
    static int[] arr;
    static boolean[] visited;
    static int N;   // 순열 크기

    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // TC 개수
        
        for (int i = 0; i < T; i++) {
            int result = 0;
            N = Integer.parseInt(br.readLine());
            
            // TC별 초기화
            visited = new boolean[N + 1];
            arr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < N + 1; j++) {
                if(!visited[j]) {
                    dfs(j);
                    result++;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int node) {
        // 방문 처리
        visited[node] = true;

        if(!visited[arr[node]]) {
            dfs(arr[node]);
        }
    }
}
