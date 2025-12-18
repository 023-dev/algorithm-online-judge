import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            
            int left = 0;
            int right = cards.length;
            while (left < right) {
                int mid = (left + right) / 2;
                
                if (cards[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int startPos = left;
            
            left = 0;
            right = cards.length;
            while (left < right) {
                int mid = (left + right) / 2;
                
                if (cards[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int endPos = left;
            
            sb.append(endPos - startPos).append(" ");
        } 
        System.out.println(sb);
    }
}