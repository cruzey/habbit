package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Num11004_2 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m_pivot_sort(arr, 0, arr.length - 1);
        System.out.println(arr[K-1]);
    }

    private static void m_pivot_sort(int[] arr, int low, int high) {
		
		if(low >= high) {
			return;
		}
		
		int pivot = partition(arr, low, high);	
		
		m_pivot_sort(arr, low, pivot);
		m_pivot_sort(arr, pivot + 1, high);
	}

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int low = left - 1;
        int high = right + 1;

        while (true) {

            //low 증가
            do{
                low++;
            } while(arr[low] < pivot);

            //high 감소
            do{
                high--;
            } while (arr[high] > pivot);

            if (low >= high) {
                return high;
            }

            swap(arr, low, high);
        }
    }

    private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
