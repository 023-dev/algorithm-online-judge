import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(positions);
        
        int left = 1;
        int right = positions[positions.length - 1] - positions[0];
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int installed = 1;
            int lastPosition = positions[0];
            
            for (int i = 1; i < N; i++) {
                if (positions[i] - lastPosition >= mid) {
                    installed++;
                    lastPosition = positions[i];
                }
            }
            
            if (installed >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}