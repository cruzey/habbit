package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2110 {
    static int N, C;
    static long[] houses;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            houses[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(houses);
        System.out.println(solve());
    }

    static long solve( ) {
        long result = 0;
        long bottom = 1;
        long top = 0;
        for (long house : houses) {
            top = Math.max(top, house);
        }
        while (bottom <= top) {
            long mid = (bottom + top) / 2;
            int cnt = 1;
            long target = houses[1];
            for (int i = 2; i < N + 1; i++) {
                if(houses[i] - target >= mid) {
                    cnt ++;
                    target = houses[i];
                }
            }

            if(cnt < C) {
                top = mid - 1;
            } else {
                result = mid;
                bottom = mid + 1;
            }
        }

        return result;

    }
}
