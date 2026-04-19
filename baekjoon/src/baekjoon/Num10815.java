package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10815 {
    static int N, M;
    static long[] arrN, arrM;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Long.parseLong(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arrM = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arrN);

        StringBuilder sb = new StringBuilder();
        for (long val: arrM) {
            sb.append(solve(val)).append(" ");
        }

        System.out.println(sb);
    }

    static int solve(long val) {
        int left = 0;
        int right = arrN.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if(arrN[mid] == val) {
                return 1;
            }else if(arrN[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
