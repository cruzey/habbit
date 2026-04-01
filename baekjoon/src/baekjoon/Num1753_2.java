package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1753_2 {
    static ArrayList<Node>[] list;
    static int[] dist; // 최단 거리를 기록할 '수첩' 역할

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int V = Integer.parseInt(st.nextToken());    // 정점의 개수
        int E = Integer.parseInt(st.nextToken());    // 간선의 개수
        int K = Integer.parseInt(br.readLine());     // 시작점의 번호

        // 1. 수첩(dist) 초기화: 아직 아무 길도 모르니까 전부 '무한대'로 적어둡니다.
        dist = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 2. 리스트 초기화 및 간선 정보 입력받기
        list = new ArrayList[V + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작
            int v = Integer.parseInt(st.nextToken()); // 도착
            int w = Integer.parseInt(st.nextToken()); // 가중치(비용)

            // u번 정점에서 v로 가는 비용은 w야! (단방향)
            list[u].add(new Node(v, w));
        }

        // 🌟 [수정 포인트 1] 잊지 말고 다익스트라 탐색 출발시키기! (방아쇠)
        solve(K); 

        // 3. 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            // 갈 수 없는 길(초기값 그대로 무한대)이면 "INF", 아니면 최단 거리 출력!
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void solve(int start) {
        // 🌟 [마법의 람다식] PQ야, Node가 들어오면 'weight(거리)'가 작은 놈부터 뽑아줘!
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        // 시작점에서 시작점까지 가는 비용은 당연히 0! 수첩에 적고 큐에 넣고 출발!
        dist[start] = 0;    
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 현재까지 발견된 경로 중 '가장 비용이 싼' 정점이 튀어나옵니다.
            Node curr = pq.poll();
            int now = curr.to;        // 현재 도착한 정점
            int weight = curr.weight; // 시작점부터 여기까지 오는데 걸린 '누적 비용'

            // 🌟 [문지기] 낡은 정보 컷!
            // 큐에서 꺼낸 비용(weight)이 이미 내 수첩(dist)에 적힌 비용보다 비싸다면?
            // "어차피 더 싼 길을 이미 찾았으니까 넌 무시할게!" 하고 넘깁니다. (속도 향상 & 무한루프 방지)
            if (dist[now] < weight) continue;

            // 현재 정점(now)과 연결된 다음 정점(next)들을 하나씩 살펴봅니다.
            for (Node next : list[now]) {
                
                // 🌟 [수정 포인트 2] 누적 요금소 계산!
                // cost = (시작점 ~ 현재 정점까지 온 비용) + (현재 정점 ~ 다음 정점까지 갈 비용)
                int cost = dist[now] + next.weight; 

                // 새롭게 계산한 누적 비용(cost)이 수첩에 적혀있던 비용보다 싸다면?! 👉 "업데이트!"
                if(cost < dist[next.to]) {
                    dist[next.to] = cost;             // 수첩을 더 싼 가격으로 고쳐 쓰고,
                    pq.add(new Node(next.to, cost));  // "이 싼 길을 거쳐서 갈 다른 길도 찾아봐!" 하며 큐에 넣음
                }
            }
        }
    }

    // 짐을 담을 가방 (도착지와 비용을 하나로 묶어줍니다)
    static class Node {
        int to;     // 도착 정점
        int weight; // 가중치(비용/거리)
    
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}