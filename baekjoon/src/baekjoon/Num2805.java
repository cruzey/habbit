package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2805 {
    static long[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무의 개수
        int M = Integer.parseInt(st.nextToken());   // 필요한 나무의 길이
        trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(N, M));
    }

    static long solve(int N, int M) {
        long bottom = 0;
        long top = 0;
        long result = 0;
        for (int i = 0; i < trees.length; i++) {
            top = Math.max(trees[i], top);
        }
        while (bottom <= top) {
            long sumOfTrees = 0;
            long height = (bottom + top) / 2;
            for (long tree : trees) {
                if(tree < height) continue;
                sumOfTrees += (tree - height);
            }
            // 구한 값이 모자른다면
            if(sumOfTrees < M) {
                top = height - 1;
            } else {
                result = height;
                bottom = height + 1;
            }
        }
        return result;
    }
}
