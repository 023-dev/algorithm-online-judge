import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        while (n --> 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(minHeap.poll()).append("\n");
                }
            } else {
                minHeap.add(x);
            }
        }
        
        System.out.print(sb);
    }
}