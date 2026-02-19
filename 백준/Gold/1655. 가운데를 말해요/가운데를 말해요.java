import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while (n --> 0) {
            int num = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            
            if (!minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(temp);
                }
            }
            
            sb.append(maxHeap.peek()).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}