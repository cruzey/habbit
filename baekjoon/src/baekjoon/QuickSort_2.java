package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuickSort_2 {

    // 복습
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());
        }
        
        pivot_quick_sort(arr, 0, N - 1);

        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    static void pivot_quick_sort (int[] arr, int left, int right) {

        if(left >= right) return;

        int pivot = partition(arr, left, right);

        pivot_quick_sort(arr, left, pivot);
        pivot_quick_sort(arr, pivot + 1, right);
        
    }

    static int partition (int[] arr, int left, int right) {
        int low = left - 1;
        int high = right + 1;
        int pivot = arr[left + (right - left) / 2];

        while (true) {
            
            do {
                low++;
            } while (arr[low] < pivot);
            
            do {
                high--;
            } while (arr[high] > pivot);

            if(low >= high){
                return high;
            }

            swap(arr, low, high);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}