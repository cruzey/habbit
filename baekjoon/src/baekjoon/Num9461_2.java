package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num9461_2 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> nList = new ArrayList<>();

        int maxVal = 0;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            nList.add(N);
            maxVal = Math.max(maxVal, N);
        }

        long[] P = solve(maxVal);
        
        nList.forEach(N -> {
            sb.append(P[N]).append("\n");
        });

        System.out.println(sb);
    }

    static long[] solve(int N) {

        long[] P = new long[N + 5];

        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        for (int i = 6; i < N + 1; i++) {
            P[i] = P[i - 1] + P[i - 5];
        }
        
        return P;
    }
}
