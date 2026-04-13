package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num2470 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solve();
        System.out.println(result[0] + " " + result[1]);

    }

    static int[] solve() {
        Arrays.sort(arr);
    
        int start = 0;
        int end = N - 1;
        
        int minSum = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (start < end) { // 두 손가락이 엇갈리면 종료!
            int currentSum = arr[start] + arr[end]; 

            // 새로운 값이 더 작으면 갱신 (절댓값으로 비교)
            if (Math.abs(currentSum) < minSum) {
                minSum = Math.abs(currentSum);
                ans1 = arr[start];
                ans2 = arr[end];
            }

            // 진짜 합계의 부호를 보고 결정
            if (currentSum > 0) {
                // 합이 양수면 너무 크니까 오른쪽 손가락을 줄여본다
                end--;
            } else if (currentSum < 0) {
                // 합이 음수면 너무 작으니까 왼쪽 손가락을 늘려본다
                start++;
            } else {
                // 0이랑 똑같다? 더 이상 완벽할 수 없으니 즉시 퇴근!
                break; 
            }
        }
        return new int[] {ans1, ans2};
    }
}
