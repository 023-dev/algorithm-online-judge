import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        List<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        while (E --> 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());            
            
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }
        
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(1, 0));
        
        int totalWeight = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.to]) {
                continue;
            }
            
            visited[current.to] = true;
            totalWeight += current.weight;
            
            for (Node next : graph[current.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }
        
        System.out.println(totalWeight);
    }
}