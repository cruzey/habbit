package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Num10866 {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            
            switch (target) {
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));

                    break;
                case "pop_front":
                    if(!q.isEmpty()) sb.append(q.pollFirst()).append("\n");
                    else sb.append("-1\n");
                    
                    break;
                case "pop_back":
                    if(!q.isEmpty()) sb.append(q.pollLast()).append("\n");
                    else sb.append("-1\n");    

                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    
                    break;
                case "front":
                    if(!q.isEmpty()) sb.append(q.peekFirst()).append("\n");
                    else sb.append("-1\n");
                    
                    break;
                case "back":
                    if(!q.isEmpty()) sb.append(q.peekLast()).append("\n");
                    else sb.append("-1\n");

                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);


    }
}
