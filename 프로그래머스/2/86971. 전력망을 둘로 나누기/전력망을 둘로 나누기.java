import java.util.*;

class Solution {
    int[][] graph;
        
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new int[n+1][n+1];
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        
        for (int[] wire : wires) {
            int wire1 = wire[0];
            int wire2 = wire[1];
            
            graph[wire1][wire2] = 0;
            graph[wire2][wire1] = 0;
            
            int count = bfs(n, wire1);
            
            int diff = Math.abs(n - (2 * count));
            answer = Math.min(diff, answer);
            
            graph[wire1][wire2] = 1;
            graph[wire2][wire1] = 1;
        }
        
        return answer;
    }
    
    int bfs(int n, int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        int count = 1;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return count;
    }
}