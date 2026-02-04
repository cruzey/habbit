package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num10845 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        List<Integer> q = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            
            String command = br.readLine();
            
            if(command.contains("push")) {
                q.add(Integer.parseInt(command.split(" ")[1]));
            } else if(command.equals("pop")) {
                if(q.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(q.remove(0)).append("\n");
                }
            } else if(command.equals("size")){
                sb.append(q.size()).append("\n");
            } else if(command.equals("empty")){
                if(q.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            } else if(command.equals("front")){
                if(q.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(q.getFirst()).append("\n");
                }
            } else if(command.equals("back")){
                if(q.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(q.getLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
