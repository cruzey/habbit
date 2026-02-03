package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Num10799 {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();

        int answer = 0;
        int n = 0;

        for(int i=0;i<problem.length()-1;i++){
            if(problem.charAt(i) == '('){		//현재 괄호가 '('일 때
                //다음 괄호가 ')' 일 때 레이저 발사!
                if(problem.charAt(i+1) == ')') {
                    answer += n;	//현재 막대기 개수만큼 잘려집니다.
                    i++;	//다다음 괄호로 이동하도록 위치 +1
                }else	//다음 괄호가 '(' 일 때 쇠막대기 추가
                    n++;
            }else{	//현재 괄호가 ')'일 때
                n--;	//현재 막대기 개수 -1
                answer++;	//잘라진 막대기 개수 + 1
            }
        }
        answer++;

        System.out.println(answer);
    }
}
