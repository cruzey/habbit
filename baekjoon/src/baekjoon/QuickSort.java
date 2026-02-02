package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder(); 

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m_pivot_sort(arr, 0, arr.length - 1); 

        for (int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    private static void m_pivot_sort(int[] arr, int low, int high) {
		
		if(low >= high) {
			return;
		}
		
		int pivot = partition(arr, low, high);	
		
		m_pivot_sort(arr, low, pivot);
		m_pivot_sort(arr, pivot + 1, high);
	}
    
    public static int partition(int[] arr, int left, int right) {

        int low = left - 1;
        int high = right + 1;
        int pivot = arr[(left + right) / 2];

        while (true) {
            
            do{
                low++;
            }while(arr[low] < pivot);

            do{
                high--;
            }while(arr[high] > pivot);

            if(low >= high){
                return high;
            }

            swap(arr, low, high);

        }

    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
