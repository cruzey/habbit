package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1806 {
    static int N, S;
    static int[] arr;
    static int minLen = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 수열의 길이
        S = Integer.parseInt(st.nextToken());   // 기준점
        arr = new int[N];                       // 수열
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);

    }

    static void solve() {
        int start = 0;
        int end = 0;
        int sum = 0;
    
        while (true) {
            if(sum >= S) {
                minLen = Math.min(end - start, minLen);
                sum -= arr[start];
                start ++;
            } else if(end == N) {
                break;
            } else {
                sum += arr[end];
                end ++;
            }
        }
    }
}

