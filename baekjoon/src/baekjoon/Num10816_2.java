package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num10816_2 {
    static int N, M;
    static long[] arrN, arrM;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(st.nextToken());
            // "이 카드 있어? 있으면 원래 개수 가져오고, 없으면 0개야. 거기다 1 더해서 넣어!"
            map.put(card, map.getOrDefault(card, 0) + 1); 
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long query = Long.parseLong(st.nextToken());
            // "이 카드 맵에 몇 개 있어? 없으면 0개라고 대답해!"
            sb.append(map.getOrDefault(query, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
