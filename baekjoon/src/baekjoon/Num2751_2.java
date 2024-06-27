package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num2751_2 {
    
    public static void main(String[] args) throws IOException{
        // StringBuilder는 시간을 줄일 수 있다...
        // Collections.sort() 좋다...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> listN = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listN.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(listN);
        
        for (Integer val : listN) {
            sb.append(val).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

}
