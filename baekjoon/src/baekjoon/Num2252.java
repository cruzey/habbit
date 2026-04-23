package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2252 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 그래프(인접 리스트)와 진입 차수 배열 준비
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[N + 1];

        // 2. 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); // a -> b (a가 b 앞에 서야 함)
            indegree[b]++; // b는 앞에 한 명이 더 생겼으므로 진입 차수 증가!
        }

        // 3. 위상 정렬 수행
        Queue<Integer> q = new LinkedList<>();
        // 처음에 진입 차수가 0인(앞에 아무도 안 서도 되는) 애들을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" "); // 결과에 추가
            
            // 현재 노드와 연결된 다음 노드들 확인
            for (int next : graph.get(now)) {
                indegree[next]--; // 선행 조건 하나 해결!
                
                // 이제 내 앞에 아무도 없다면(0이 되면) 큐에 삽입
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
