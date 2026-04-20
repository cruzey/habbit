package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10816 {
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
        for (long val : arrM) {
            int count = upperBound(val) - lowerBound(val);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(long val) {
        int left = 0;
        // 🚨 주의: upper bound가 배열의 끝을 넘어설 수도 있으므로 length - 1 이 아니라 length 로 둡니다!
        int right = arrN.length; 
        
        while (left < right) {
            int mid = (left + right) / 2;
            // 찾는 값(val)이 mid의 값과 '같거나' 작으면? 
            // -> 정답이 될 수 있는 애가 더 왼쪽에 있을 수도 있으니까 오른쪽을 좁힌다!
            if (val <= arrN[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

        static int upperBound(long val) {
        int left = 0;
        int right = arrN.length; 
        
        while (left < right) {
            int mid = (left + right) / 2;
            // 찾는 값(val)이 mid의 값보다 '무조건 작을 때만' 오른쪽을 좁힌다!
            // (같을 때는 왼쪽을 당겨서 계속 오른쪽으로 밀어붙여야 함)
            if (val < arrN[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
