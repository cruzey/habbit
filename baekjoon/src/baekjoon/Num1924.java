package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1924 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] year = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int setCal = 0;

        for (int i = 0; i < month; i++) {
            setCal += year[i];
        }
        setCal += day;
      System.out.println(days[setCal%7]);

    }
}
