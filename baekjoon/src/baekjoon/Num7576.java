package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Num7576 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[]{j, i});
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
    	int days = -1;
    	
        while (!q.isEmpty()) {
        	int flag = q.size();
        	//new day
        	days ++;
        	
        	//for print console
        	System.out.println("day : " + days);
        	System.out.println("queue : " + q.size());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            
        	for(int j = 0; j < flag; j++) {
        		//target coordinate
        		int[] t = q.poll();
        		int x = t[0];
        		int y = t[1];
        		for (int i = 0; i < 4; i++) {
        			int nx = x + dx[i];
        			int ny = y + dy[i];
        			if ((0 <= nx && nx < m) && (0 <= ny && ny < n) && (map[ny][nx] == 0)) {
        				map[ny][nx] = 1;
        				System.out.println("new x, y : " + nx + ", " + ny);
        				q.add(new int[]{nx, ny});
        			}
        		}
        	}
        	
        }

        if (checkZero()) {
            return -1;
        } else {
            return days;
        }
    }

    private static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}