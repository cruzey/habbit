package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1654 {
    static int K, N;
    static long[] lines;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new long[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        System.out.println(solve());

    }

    static long solve() {
        long result = 0;
        long bottom = 1;
        long top = 0;
        for (long line : lines) {
            top = Math.max(top, line);
        }

        while (bottom <= top) {
            long saw = (bottom + top) / 2;
            int numOfLines = 0;
            for (long line : lines) {
                numOfLines += (line / saw);
            }        

            if(numOfLines < N) {
                top = saw - 1;
            }
            else {
                result = saw;
                bottom = saw + 1;
            }
        }
        return result;
    }
}
