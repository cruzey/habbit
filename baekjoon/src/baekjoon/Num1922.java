package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num1922 {
    static int N, M;    // 컴퓨터의 수, 연결 선의 수
    static int[] parent; // 각 컴퓨터의 보스를 적어두는 수첩
    static ArrayList<Node> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int result = 0;
        
        // 초기화
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        list = new ArrayList<>();
        
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        Collections.sort(list, (a, b) -> a.cost - b.cost);

        for (Node curr : list) {
            if(find(curr.start) != find(curr.end)) {
                union(curr.start, curr.end);
                result += curr.cost;
            }
        }

        System.out.println(result);

    }

    // 1. 내 최종 보스가 누군지 찾아주는 함수 (Find)
    static int find(int x) {
        if (x == parent[x]) {
            return x; // 내가 내 보스면(최종 보스면) 내 번호 리턴!
        }
        // 내 보스가 따로 있으면, 그 보스의 보스를 찾아서 내 보스로 업데이트! (경로 압축 최적화)
        return parent[x] = find(parent[x]); 
    }

    // 2. 두 그룹을 하나로 합치는 함수 (Union)
    static void union(int a, int b) {
        int rootA = find(a); // a의 최종 보스
        int rootB = find(b); // b의 최종 보스

        if (rootA != rootB) {
            parent[rootB] = rootA; // B의 보스를 A로 바꿔서 흡수 통폐합!
        }
    }
    
    static class Node{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    
}
