package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10818 {
    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (i == 0){
                max = tmp;
                min = tmp;
            }else if (max < tmp) {
                max = tmp;
            }else if(min > tmp){
                min = tmp;
            }
        }

        System.out.println(min + " " + max);
    }
}
