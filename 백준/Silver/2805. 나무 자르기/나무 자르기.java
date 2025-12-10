import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // sort for binary search
        Arrays.sort(arr);
        
        // binary search
        long left = 0;
        long right = arr[arr.length-1];
        long result = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += (arr[i] - mid);   
                }
            }
            
            if (sum >= M) {
                result = mid; 
                left = mid + 1;
            } else if (sum < M) {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}