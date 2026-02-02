package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Num9012 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        List<String> sList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            sList.add(br.readLine());
        }

        for (String s : sList) {
            int flag = 0;
            
            if(s.charAt(0) != '(') {
                System.out.println("NO");
                continue;
            } else {
                flag ++;
            }

            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i) =='('){
                    flag++;
                } else {
                    flag --;
                }

                if (flag < 0) {
                    System.out.println("NO");
                    break;
                }
            }

            if(flag < 0){
                continue;
            } else if(flag == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
