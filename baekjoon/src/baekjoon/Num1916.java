package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1916 {
    static ArrayList<Bus>[] list;
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 도시의 개수
        int M = Integer.parseInt(br.readLine());        // 버스의 개수

        // 초기화
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());   // 출발지
            int dest = Integer.parseInt(st.nextToken());    // 도착지
            int cost = Integer.parseInt(st.nextToken());    // 비용

            list[start].add(new Bus(dest, cost));
        }

        st = new StringTokenizer(br.readLine());
        int dep = Integer.parseInt(st.nextToken());     // 경로의 시작점
        int arr = Integer.parseInt(st.nextToken());     // 경로의 도착점

        solve(dep, arr);
        
        System.out.println(dist[arr]);
    }

    static void solve(int dep, int arr) {
        // 가장 적은 비용부터 pop
        PriorityQueue<Bus> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        
        // 자기자신 0이 필요 없으려나?

        // 시작점에 있는 모든 경로 pq에 add
        for (Bus bus : list[dep]) {
            pq.add(bus);
        }

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();
            // 이미 알고있는 비용보다 더 작으면 갱신
            if(bus.cost < dist[bus.dest]) dist[bus.dest] = bus.cost;
            // 도착지이면 다음으로
            if(bus.dest == arr) continue;
            //도착지에서 다시 출발하는 버스 모두 탐색
            for (Bus newBus : list[bus.dest]) {
                // 현재까지 거리를 합산하여 pq에 add
                pq.add(new Bus(newBus.dest, newBus.cost + dist[bus.dest]));
            }
        }
    }

    static class Bus {
        int dest;
        int cost;

        public Bus(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
