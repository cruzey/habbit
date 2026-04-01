package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1753_3 {
    static int[] dist;                  // 도착지까지의 가중치 배열
    static ArrayList<Node>[] list;      // 연결된 간선과 그 가중치가 담길 리스트
    static int V, E;                    // 정점의 개수, 간선의 개수
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());        // 시작점

        //초기화
        dist = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // u에서 v까지 가는 가중치는 w이다.
            list[u].add(new Node(v, w));
        }
        
        solve(K);

        for (int i = 1; i < V + 1; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }

        System.out.println(sb);
        
    }

    static void solve(int start) {
        // weight 라는 가중치가 작은 것부터 아웃
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        //자기자신까지의 가중치는 0
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int to = currNode.to;           // 현재에서 이어진 도착지
            int weight = currNode.weight;   // 그만큼의 가중치

            // 이미 알고있는 to까지의 가중치가 새로 계산한 가중치보다 작으면 볼 필요 없음
            if(dist[to] < weight) continue;
            
            for (Node nextNode : list[to]) {
                int nextTo = nextNode.to;
                int nextWeight = nextNode.weight;
                int totalWeight = weight + nextWeight;     //nextTo까지의 가중치

                // nextTo까지의 현재 가중치보다 새로 찾은 가중치가 더 작다면
                if(dist[nextTo] > totalWeight) {
                    // 갱신
                    dist[nextTo] = totalWeight;
                    // pq에 추가
                    pq.add(new Node(nextTo, totalWeight));
                }
            }
        }


    }

    static class Node {
        int to;         // 연결된 정점
        int weight;     // 가중치

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}