package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Num11652_2 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long m = Long.parseLong(br.readLine());
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        int max = -1;
        long num = 0;

        for (Entry<Long, Integer> i : map.entrySet()) {
            if(i.getValue() > max) {
                max = i.getValue();
                num = i.getKey();
            } else if(i.getValue() == max) {
                num = num > i.getKey() ? i.getKey() : num;
            }
        }
        System.out.println(num);
    }
}
