package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num11650 {

    static class Coordinate {
        int x;
        int y;

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
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> listN = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            Coordinate newI = new Coordinate();
            newI.setX(Integer.parseInt(st.nextToken()));
            newI.setY(Integer.parseInt(st.nextToken()));

            listN.add(newI);
        }

        sort(listN);
        for (Coordinate coordinate : listN) {
            sb.append(coordinate.toString() + "\n");
        }
        br.close();
        System.out.println(sb);

    }

    static void sort(ArrayList<Coordinate> list){

        if (list.size() <= 1) {
            return;
        }

        Coordinate pivot = list.get(0);
        ArrayList<Coordinate> left = new ArrayList<>();
        ArrayList<Coordinate> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).getX() == pivot.getX()) {
                if(list.get(i).getY() < pivot.getY()){
                    left.add(list.get(i));
                }else{
                    right.add(list.get(i));
                }
            } 
            else if(list.get(i).getX() < pivot.getX()){
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
    }
}
