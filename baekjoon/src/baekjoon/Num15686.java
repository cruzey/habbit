package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num15686 {

    static int N, M;
    static int[][] map;

    static ArrayList<chicken> ckList = new ArrayList<>();
    static ArrayList<house> hsList = new ArrayList<>();
    static ArrayList<Integer> resultList = new ArrayList<>();

    static class chicken{
        int r;
        int c;
        chicken(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static class house{
        int r;
        int c;
        house(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        setUp();
        
        for(house hs : hsList){
            int ckDis = Integer.MAX_VALUE;

            for(chicken ck : ckList){
                int dis = calDis(hs, ck);
                ckDis = Math.min(dis, ckDis);
            }
            resultList.add(ckDis);
        }

        System.out.println(calRes());
    }

    static void setUp() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){
                    ckList.add(new chicken(i, j));
                }
                else if(map[i][j] == 1){
                    hsList.add(new house(i, j));
                }

            }
        }
    }

    static int calDis(house hs, chicken ck){
        int dis = Math.abs(hs.r - ck.r) + Math.abs(hs.c - ck.c);
        return dis;
    }

    static int calRes(){
        int result = 0;
        resultList.sort(Comparator.naturalOrder());
        System.out.println(resultList);
        
        for(int i=0; i<M; i++){
            result = result + resultList.get(i);
        }

        return result;
    }
}
