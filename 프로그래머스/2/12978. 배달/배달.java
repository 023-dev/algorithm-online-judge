import java.util.*;

class Solution {
    
    static class Node {
        int next;
        int cost;
        
        Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] roads, int K) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        

        for (int[] road : roads) {
            int current = road[0];
            int next = road[1];
            int cost = road[2];
            
            graph.get(current).add(new Node(next, cost));
            graph.get(next).add(new Node(current, cost));
        }
        
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.cost > distances[current.next]) continue;
            
            for (Node next : graph.get(current.next)) {
                int newCost = current.cost + next.cost;
                
                if (newCost < distances[next.next]) {
                    distances[next.next] = newCost;
                    pq.offer(new Node(next.next, newCost));
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) count++;
        }
        
        return count;
    }
}