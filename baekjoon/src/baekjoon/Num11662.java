package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11662 {
    static Point A, B, C, D;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        B = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        C = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        D = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        // left와 right는 시간의 '비율(퍼센트)'를 나타냅니다. 0부터 100퍼센트까지!
        double left = 0.0;
        double right = 100.0;

        // 소수점 아래로 아주 정밀하게 찾아야 하므로, 100번 정도 반복하면 충분히 좁혀집니다.
        for (int i = 0; i < 100; i++) {
            // 3등분 하는 두 지점 (p1은 왼쪽에서 1/3 지점, p2는 왼쪽에서 2/3 지점)
            double p1 = (2 * left + right) / 3.0;
            double p2 = (left + 2 * right) / 3.0;
            
            // p1 퍼센트일 때의 민호와 강호의 좌표를 구해서 두 점 사이의 거리를 계산 (함수로 빼면 편해요!)
            double dist1 = getDistance(p1); 
            // p2 퍼센트일 때의 민호와 강호의 좌표를 구해서 두 점 사이의 거리를 계산
            double dist2 = getDistance(p2); 

            if (dist1 > dist2) {
                // p2 쪽이 더 바닥과 가깝다! 왼쪽 범위를 버리자.
                left = p1;
            } else {
                // p1 쪽이 더 바닥과 가깝다! 오른쪽 범위를 버리자.
                right = p2;
            }
        }

        // 루프가 끝나면 left나 right나 거의 똑같은 바닥 위치에 도달해 있습니다!
        System.out.println(getDistance(left));

    }

    static double getDistance (double p) {
        double x = A.x + (B.x - A.x) * (p / 100.0);
        double y = A.y + (B.y - A.y) * (p / 100.0);
        Point minho = new Point(x, y);
        
        x = C.x + (D.x - C.x) * (p / 100.0);
        y = C.y + (D.y - C.y) * (p / 100.0);
        Point gangho = new Point(x, y);

        // 3. 두 사람(두 점) 사이의 직선 거리 구해서 반환하기!
        double distance = Math.sqrt(Math.pow(gangho.x - minho.x, 2) + Math.pow(gangho.y - minho.y, 2));
        return distance;
    }

    static class Point {
        double x;
        double y;

        public Point (double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
