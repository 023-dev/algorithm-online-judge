import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        Set<Integer> heightSet = new HashSet();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                heightSet.add(map[i][j]);
            }
        }
        
        int maxZone = 1;
        for (int height : heightSet) {
            int zone = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]
                        && map[i][j] > height) {
                        bfs(i, j, height);
                        zone++;
                    }
                }
            }
            maxZone = Math.max(maxZone, zone);
        }
        
        System.out.println(maxZone);
    }
    
    static void bfs(int i, int j, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        
        while(!q.isEmpty()) {
            int[] position = q.poll();
            int curX = position[0];
            int curY = position[1];            
            for (int k = 0; k < 4; k++) {
                int nextX = curX + dX[k];
                int nextY = curY + dY[k];
                if (map.length > nextX 
                    && map.length > nextY
                    && 0 <= nextX
                    && 0 <= nextY) {
                    if (map[nextX][nextY] > height
                        && !visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}