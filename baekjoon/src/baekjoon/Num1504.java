package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1504 {
    static int[] dist;
    static ArrayList<Node>[] list;
    static int N, E;    // 정점, 간선
    // 합연산의 오버플로우 때문에 Integer.Max_VALUE(약 21억) 대신 2억 사용
    static final int MAX_VALUE = 200000000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수
        
        // 초기화
        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            
            dist[i] = MAX_VALUE;
        }
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());   // 시작점 
            int b = Integer.parseInt(st.nextToken());   // 도착점
            int c = Integer.parseInt(st.nextToken());   // 거리

            // a에서 출발하여 b에 도착하는 경로상 거리, 양방향!!
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));

        }

        st = new StringTokenizer(br.readLine());
        // 반드시 지나야 함
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = solve(1, v1) + solve(v1, v2) + solve(v2, N);
        int path2 = solve(1, v2) + solve(v2, v1) + solve(v1, N);

        int result = Math.min(path1, path2);

        if (result >= MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

    }

    // 주어진 시작점부터 도착지까지 거리의 최솟값 계산
    static int solve(int start, int end) {
        // weight가 작은 node부터 pop
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        // 자기자신까지 거리 0
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            // 도착지한 곳이 end라면 종료
            if(node.to == end) {
                break;
            }
            // 이미 알고있는 거리가 새로운 정보보다 더 작다면 볼 필요없다
            if(dist[node.to] < node.weight) continue;

            // 현재 도착한 정점에서 이어지는 모든 경우의 수
            for (Node nextNode : list[node.to]) {
                int totalWeight = node.weight + nextNode.weight;
                // 다음 도착지까지 알고있는 거리보다 현재 거리가 더 짧으면 갱신
                if(dist[nextNode.to] > totalWeight) {
                    dist[nextNode.to] = totalWeight;
                    pq.add(new Node(nextNode.to, totalWeight));
                }
            }
        }
        
        // 이미 도착한 곳까지의 정보는 모두 최솟값이 적용되어있음
        int result = dist[end];
        // 재사용
        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dist[i] = MAX_VALUE;
        }
        return result;

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
