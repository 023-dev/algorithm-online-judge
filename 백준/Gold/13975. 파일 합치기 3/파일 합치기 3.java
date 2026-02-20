import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t --> 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (k --> 0) {
                minHeap.add(Long.parseLong(st.nextToken()));
            }
            
            long cost = 0;
            while (minHeap.size() > 1) {
                long x1 = minHeap.poll();
                long x2 = minHeap.poll();
                long sum = x1 + x2;
                cost += sum;
                minHeap.add(sum);   
            }
            
            sb.append(cost).append("\n");
        }
        System.out.print(sb.toString());
    }
}