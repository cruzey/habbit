package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14503 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int resultCnt = 1;
	
	static class Robo{
		//줄
		private int r;
		//칸
		private int c;
		//0:북, 1:동, 2:남, 3:서
		private int direction;
		
		Robo(int r, int c, int direction){
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
		
		public int getDirection() {
			return direction;
		}
		public void setDirection(int direction) {
			this.direction = direction;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		
	}	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//map info
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		//robo info
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		Robo robo = new Robo(r, c, dir);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(robo);
		
		System.out.println(resultCnt);
		
//		for(int i=0; i<N; i++) {
//			System.out.println();
//			for(int j=0; j<M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//		}
		
	}
	
	static void clean(Robo robo) {
    	int r = robo.getR();
    	int c = robo.getC();
    	int dir = robo.getDirection();
    	
    	map[r][c] = 2; 
        
        for(int i = 0; i < 4; i++) {
        	//시계 반대방향으로 90도씩 회전 
        	dir = (dir + 3) % 4;
                       
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if(map[nr][nc] == 0) {
                    resultCnt++;
                    robo.setR(nr);
                    robo.setC(nc);
                    robo.setDirection(dir);
                    clean(robo);
                    return;
                }
            }
        }
        dir = (dir + 2) % 4;
        int br = r + dr[dir];
        int bc = c + dc[dir];
        if(br >= 0 && bc >= 0 && br < N && bc < M && map[br][bc] != 1) {
        	robo.setR(br);
            robo.setC(bc);
        	clean(robo);
        }
    }
	
}
