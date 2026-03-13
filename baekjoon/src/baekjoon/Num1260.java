package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1260 {
    static int[][] arr; // 지도 (인접 행렬)
    static boolean[] visited; // 발도장 (방문 체크)
    static int N; // 정점의 개수
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());       // 점의 개수        
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수    
        int V = Integer.parseInt(st.nextToken());   // 시작점     
        
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 양방향 연결이므로 양쪽 다 1로 체크해줍니다!
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 1. DFS 실행
        visited = new boolean[N + 1]; // 방문 배열 초기화
        dfs(V);
        System.out.println(); // 줄바꿈

        // 2. BFS 실행
        visited = new boolean[N + 1]; // BFS를 위해 방문 배열을 다시 새 걸로 초기화!
        bfs(V);
    }

    public static void dfs(int node) {
        // 1. 현재 노드 방문 처리 (visited = true)
        visited[node] = true;
        // 2. 현재 노드 출력 (System.out.print(node + " "))
        System.out.print(node + " ");
        // 3. 1번부터 N번까지 반복문 돌면서
        //    "나랑 연결되어 있고(arr[node][i] == 1) && 아직 안 가본 곳(!visited[i])" 이면 dfs(i) 호출!
        for (int i = 1; i < N + 1; i++) {
            if(arr[node][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        // 1. 큐에 시작 노드를 넣고 방문 처리
        q.add(start);
        visited[start] = true;
        // 2. 큐가 빌 때까지(q.isEmpty() == false) 계속 반복:
        while (!q.isEmpty()) {   
            //    3. 큐에서 하나 꺼내서 출력
            int val = q.poll();
            System.out.print(val + " ");
            //    4. 1번부터 N번까지 반복문 돌면서
            for (int i = 1; i < N + 1; i++) {
                //       "꺼낸 노드랑 연결되어 있고 && 아직 안 가본 곳" 이면 큐에 넣고 방문 처리!
                if(arr[val][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }

            }
        }
    }

}
