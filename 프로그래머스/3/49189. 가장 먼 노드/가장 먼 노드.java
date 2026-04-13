import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] distances = new int[n+1];
        Arrays.fill(distances, -1);
        q.offer(1);
        distances[1] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int next : graph.get(current)) {
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1;
                    q.offer(next);
                }
            }
        }
        
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distances[i]);
        }
        
        int answer = 0;
        for (int distance : distances) {
            if (distance == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}