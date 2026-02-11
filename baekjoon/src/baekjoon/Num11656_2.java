package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Num11656_2 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < S.length(); i++) {
            list.add(S.substring(i, S.length()));
        }

        List<String> nList = list.stream().sorted().collect(Collectors.toList());

        for (String string : nList) {
            System.out.println(string);
        }
    }

}
