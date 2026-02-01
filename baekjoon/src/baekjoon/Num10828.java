package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Num10828 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Stack stack = new Stack();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.getSize();
                    break;
                case "empty":
                    stack.isEmpty();
                    break;
                case "top":
                    stack.top();
                    break;
            
                default:
                    break;
            }
            
        }

        System.out.println(stack.sb.toString());
        
    }

    public static class Stack {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
    
        public void push(int x) {
            list.add(x);
        }
    
        public void pop() {
            if (list.isEmpty()) {
                sb.append("-1\n");
            } else {
                sb.append(list.remove(list.size() - 1)).append("\n");
            }
        }
    
        public void getSize() {
            sb.append(list.size()).append("\n");
        }
    
        public void isEmpty() {
            sb.append(list.isEmpty() ? "1\n" : "0\n");
        }
    
        public void top() {
            if (list.isEmpty()) {
                sb.append("-1\n");
            } else {
                sb.append(list.get(list.size() - 1)).append("\n");
            }
        }
    }

}
