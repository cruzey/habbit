package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num9465 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            // solve 결과를 StringBuilder에 담기
            sb.append(solve(n, sticker)).append("\n");
        }
        System.out.println(sb);
    }

    static int solve(int n, int[][] sticker) {
        // n이 1일 때
        if (n == 1) {
            return Math.max(sticker[0][0], sticker[1][0]);
        }

        //dp[2][n] = 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값
        // if(i % 2 == 0) dp[i][j] = dp[1][j - 1] > dp[1][j - 2] ? dp[1][j - 1] : dp[1][j - 2] + sticker[i][j]; 
        // if(i % 2 == 1) dp[i][j] = dp[0][j - 1] > dp[0][j - 2] ? dp[0][j - 1] : dp[0][j - 2] + sticker[i][j];

        //점화식은 맞지만 계산 순서의 오류 발생

        //바깥쪽 루프가 i(행), 안쪽 루프가 j(열)입니다.
        // i = 0 일 때 (위쪽 스티커 루프 시작):
        // j = 2: dp[0][2]를 구하기 위해 dp[1][1]과 dp[1][0]을 참조합니다. (여기까진 초기값이 있어서 괜찮습니다.)
        // j = 3: dp[0][3]을 구하기 위해 dp[1][2]와 dp[1][1]을 참조해야 합니다.
        // 앗! 여기서 문제가 발생합니다. dp[1][2]는 아래쪽 스티커의 2번째 열 값인데, 아직 계산되지 않았습니다! (왜냐하면 i = 1 루프는 i = 0이 다 끝나야 시작하니까요.)
        // 결국 계산되지 않은 기본값 0을 가져와서 더해버리게 됩니다.
        // 즉, DP는 **"과거의 꽉 찬 데이터"**를 밟고 지나가야 하는데, 지금 코드는 가로로 쭉 직진만 하려다 보니 **"아직 짓지도 않은 다리(아래쪽 행)"**를 밟으려고 하는 것과 같습니다.

        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 2; j < dp[i].length; j++) {
        //         if(i % 2 == 0) dp[i][j] = (dp[1][j - 1] > dp[1][j - 2] ? dp[1][j - 1] : dp[1][j - 2]) + sticker[i][j];
        //         else dp[i][j] = (dp[0][j - 1] > dp[0][j - 2] ? dp[0][j - 1] : dp[0][j - 2]) + sticker[i][j];
        //     }
        // }

        // int result = 0;
        // for (int[] is : dp) {
        //     for (int is2 : is) {
        //         if(is2 > result) result = is2;
        //     }
        // }

        int[][] dp = new int[2][n];

        // 초기값 (i = 0)
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        // 초기값 (i = 1) -> 대각선의 경우의 수만 존재
        dp[0][1] = dp[1][0] + sticker[0][1];
        dp[1][1] = dp[0][0] + sticker[1][1];

        // i = 2부터 점화식 적용
        for (int i = 2; i < n; i++) {
            // 내가 위쪽(0)을 뗄 거면, 왼쪽 대각선(1, i-1)과 그 왼쪽 대각선(1, i-2) 중 큰 값에 나를 더함
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
            
            // 내가 아래쪽(1)을 뗄 거면, 왼쪽 대각선(0, i-1)과 그 왼쪽 대각선(0, i-2) 중 큰 값에 나를 더함
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
        }

        // 마지막 열에서 위쪽으로 끝난 경우와 아래쪽으로 끝난 경우 중 더 큰 값이 최종 정답!
        return Math.max(dp[0][n - 1], dp[1][n - 1]);

    }
}

