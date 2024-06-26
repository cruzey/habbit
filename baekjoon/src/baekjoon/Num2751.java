package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num2751 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> listN = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            listN.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(listN);
        System.out.println(quickSort(listN));
        // for( int i : quickSort(listN)){
        //     System.out.println(i);
        // }     
    }

    static ArrayList<Integer> quickSort(ArrayList<Integer> list){
        if(list.size() < 1) return list;

        int pivot = list.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();


        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) < pivot){
                left.add(list.get(i));
            }else{
                right.add(list.get(i));
            }
        }

        result.addAll(quickSort(left));
        result.add(pivot);
        result.addAll(quickSort(right));
        return result;
    }
}
