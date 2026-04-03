package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1916_2 {
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
        // 필요했다,,, 자기자신 0으로 해서 시작하는 것이 맞다
        dist[dep] = 0;
        pq.add(new Bus(dep, 0));

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();
            // 이미 알고있는 비용보다 더 작으면 갱신
            // 이미 알고있는 비용보다 더 크면 무시가 맞다 
            if(bus.cost > dist[bus.dest]) continue;

            // 도착지이면 다음으로
            // if(bus.dest == arr) continue;
            // 도착지에 도착했다면? 어차피 싼 놈부터 꺼냈으니 이게 무조건 최저가
            // 다른 경우의 수를 볼 필요가 없었다,, pq이니까
            if (bus.dest == arr) break;

            //도착지에서 다시 출발하는 버스 모두 탐색
            for (Bus newBus : list[bus.dest]) {
                int totalCost = newBus.cost + dist[bus.dest];
                // 총 요금이 이미 알고있는 비용보다 싸면
                if (totalCost < dist[newBus.dest]) {
                    dist[newBus.dest] = totalCost; // 수첩 갱신
                    // 총비용을 가진 버스 add
                    pq.add(new Bus(newBus.dest, totalCost));
                }
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
