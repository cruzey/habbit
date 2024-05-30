package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num10950 {

    static int m;


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());  
        Queue q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.add(st.nextToken());
            q.add(st.nextToken());
        }

        while (!q.isEmpty()) {
           System.out.println(Integer.parseInt(q.poll().toString()) + Integer.parseInt(q.poll().toString()));
        }
    }
}