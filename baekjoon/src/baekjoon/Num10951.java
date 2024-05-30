package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num10951 {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String s = br.readLine();
            if(s == null || s.equals(null)) break;
            
            StringTokenizer st = new StringTokenizer(s);
            System.out.println(Integer.parseInt(st.nextToken().toString()) + Integer.parseInt(st.nextToken().toString()));
        }

    }
}
