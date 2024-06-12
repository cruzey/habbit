package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10818_2 {
    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] list = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        max = Arrays.stream(list).max().getAsInt();
        min = Arrays.stream(list).min().getAsInt();

        System.out.println(min + " " + max);
    }
}
