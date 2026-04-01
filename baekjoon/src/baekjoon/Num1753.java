package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1753 {
    static ArrayList<Node>[] list;
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int V = Integer.parseInt(st.nextToken());    // 정점의 개수
        int E = Integer.parseInt(st.nextToken());    // 간선의 개수
        int K = Integer.parseInt(br.readLine());     // 시작점의 번호 (1 <= K <= V)

        // 가중치 초기화
        dist = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 리스트 초기화
        list = new ArrayList[V + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());

            // u에서 v로 가는 가중치 w인 간선
            int u = Integer.parseInt(st.nextToken()); // 시작
            int v = Integer.parseInt(st.nextToken()); // 도착
            int w = Integer.parseInt(st.nextToken()); // 가중치

            // u번 리스트에서 v 가는 비용은 w
            list[u].add(new Node(v, w));
            // 반대 경우, 이 문제는 단방향만
            // list[v].add(new Node(u, w));
        }

        solve(K);

        for (int i = 1; i < V + 1; i++) {
            System.out.println( dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
       
    }

    static void solve(int start) {
        dist[start] = 0;    // 자기자신까지의 가중치는 0

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        // '시작점에서 시작점까지 가중치는 0' 을 pq에 추가
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.to;
            int weight = curr.weight;

            // 💥 [핵심] 큐에서 꺼낸 거리가 이미 기록된 최단 거리보다 크다면?
            // 이미 더 짧은 경로로 처리된 적이 있다는 뜻이므로 무시하고 넘어갑니다!
            if (dist[now] < weight) continue;

            for (Node next : list[now]) {
                // 1. 새로운 경로의 '누적 거리'를 계산합니다.
                // 지금까지 온 거리(dist[now] 또는 weight) + 앞으로 한 칸 더 갈 거리(next.weight)
                int cost = dist[now] + next.weight; 
                
                // 2. 그 '누적 거리'가 기존에 수첩(dist)에 적힌 거리보다 짧다면?
                if (cost < dist[next.to]) {
                    // 3. 수첩 업데이트!
                    dist[next.to] = cost;
                    
                    // 4. 큐에 넣을 때도 반드시 '누적 거리'를 담은 새로운 가방을 만들어서 넣어줘야 합니다!
                    pq.add(new Node(next.to, cost)); 
                }
            }
        }

    }

    static class Node {
        int to;     // 도착 정점
        int weight; // 가중치(거리)
    
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
