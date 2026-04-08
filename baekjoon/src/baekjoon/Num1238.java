package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1238 {
    static int N, M, X;   // 학생 수 = 마을 수, 도로 수, 파티 마을
    static ArrayList<Node>[] list, reverseList;
    static int[] distGo, distCome;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        // 초기화
        distGo = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distGo[i] = Integer.MAX_VALUE;
        }
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        // 역방향도 초기화
        distCome = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distCome[i] = Integer.MAX_VALUE;
        }
        reverseList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // s마을에서 e마을까지 c시간만큼의 단방향 거리
            list[s].add(new Node(e, c));
            // 파티마을까지의 시간계산을 위한 역방향 그래프
            reverseList[e].add(new Node(s, c));
        }

        dijkstra(X, reverseList, distCome);     // 각 마을에서 파티마을까지 오는 소요시간을 역으로
        dijkstra(X, list, distGo);              // 파티 마을에서 집으로 돌아가는 소요시간

        for (int i = 1; i < N + 1; i++) {
            result = Math.max(distCome[i] + distGo[i], result);
        }

        System.out.println(result);
    }

    static void dijkstra(int start, ArrayList<Node>[] list, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        // 자기 자신까지 소요시간 0
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int now = curr.to;
            int cost = curr.weight;

            if(dist[now] < cost) continue;

            for (Node nextNode : list[now]) {
                int next = nextNode.to;
                int newCost = nextNode.weight;
                int totalCost = cost + newCost;

                if(dist[next] > totalCost) {
                    dist[next] = totalCost;
                    pq.add(new Node(next, totalCost));
                }
            }
        }
        
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
