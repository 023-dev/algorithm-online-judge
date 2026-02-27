import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    class Node implements Comparable<Node> {
        int x, y, cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int n = land.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        int answer = 0;
        
        pq.offer(new Node(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;
            answer += now.cost;
            
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if (nextX >= 0 && nextX < n && 
                    nextY >= 0 && nextY < n) {
                    
                    int gap = Math.abs(land[now.x][now.y] - land[nextX][nextY]);
                    int nextCost = 0;
                    
                    if (gap <= height) {
                        nextCost = 0;
                    } else {
                        nextCost = gap;
                    }
                    
                    pq.offer(new Node(nextX, nextY, nextCost));
                }
                
            }
            
        }
        return answer;
    }
}