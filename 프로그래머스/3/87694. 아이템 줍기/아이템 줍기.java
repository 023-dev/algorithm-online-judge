import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];
        
        // 1. 좌표 2배 확장 및 맵에 직사각형 그리기
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2, x2 = r[2] * 2, y2 = r[3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    // 이미 다른 직사각형의 내부에 포함된 부분은 덮어쓰지 않음
                    if (map[x][y] == 2) continue;
                    
                    // 직사각형의 경계선 설정
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        map[x][y] = 1;
                    } else {
                        // 직사각형의 내부 설정
                        map[x][y] = 2;
                    }
                }
            }
        }
        
        // 2. BFS 탐색을 위한 초기화
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX * 2, characterY * 2});
        
        boolean[][] visited = new boolean[102][102];
        visited[characterX * 2][characterY * 2] = true;
        
        int[][] dist = new int[102][102];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 3. BFS 실행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 목표 지점 도달 시 2로 나누어 반환
            if (cx == itemX * 2 && cy == itemY * 2) {
                return dist[cx][cy] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 맵의 범위를 벗어나지 않고, 외곽선(1)이며, 방문하지 않은 곳
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}