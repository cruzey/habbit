package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num11651 {

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate() {
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
        @Override
        public String toString() {
            return this.getX() + " " + this.getY();
        }
        @Override
        public int compareTo(Coordinate o) {
            if(this.getY() == o.getY()){
                return this.getX() - o.getX();
            }else{
                return this.getY() - o.getY();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> listN = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            listN.add(new Coordinate(x, y));
        }

        sort(listN);

        for (Coordinate coordinate : listN) {
            System.out.println(coordinate.toString());
        }

        br.close();
    }

    static void sort(ArrayList<Coordinate> list){
        
        if(list.size() < 1){
            return;
        }
        
        ArrayList<Coordinate> left = new ArrayList<>();
        ArrayList<Coordinate> right = new ArrayList<>();
        Coordinate pivot = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int flag = pivot.compareTo(list.get(i));
            if(flag > 0){
                left.add(list.get(i));
            }else{
                right.add(list.get(i));
            }
        }

        sort(left);
        sort(right);

        list.clear();
        list.addAll(left);
        list.add(pivot);
        list.addAll(right);
        left.clear();
        right.clear();
    }
}
