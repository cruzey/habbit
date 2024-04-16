package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num14502 {
	
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static int[][] copyMap;
	static int max_sfz_count = 0;
	
	static class Node {
        int x;
        int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);

		System.out.println(max_sfz_count);
		
	}
	
	static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		
		Queue<Node> q = new LinkedList<>();
		copyMap = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				copyMap[i][j] = map[i][j];
				if(copyMap[i][j] == 2) {
					q.add(new Node(j, i));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node t = q.poll();
			int x = t.x;
			int y = t.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x +dx[i];
				int ny = y +dy[i];
				
				if((0 <= nx && nx < m) && (0 <= ny && ny < n) && (copyMap[ny][nx] == 0)) {
					copyMap[ny][nx] = 2;
					q.add(new Node(nx, ny));
				}
			}
		}
		get_sfz_count(copyMap);
	}
	
	static void get_sfz_count(int[][] copyMap) {
		int sfz_count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copyMap[i][j] == 0) {
					sfz_count++;
				}
			}
		}
		
//		if(max_sfz_count < sfz_count) {
//			max_sfz_count = sfz_count;
//		}
		max_sfz_count = Math.max(sfz_count, max_sfz_count);

	}
	
}
