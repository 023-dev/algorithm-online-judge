import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> cardBundles = new PriorityQueue();
        while (n --> 0) {
            int cardBundle = Integer.parseInt(br.readLine());
            cardBundles.add(cardBundle);
        }
        
        if (cardBundles.size() == 1) {
            System.out.print(0);
            return;
        }
        
        int count = 0;
        while (cardBundles.size() > 1) {
            int a = cardBundles.poll();
            int b = cardBundles.poll();
            count += (a + b);
            cardBundles.add(a+b);
        }
        
        System.out.print(count);
    }
}