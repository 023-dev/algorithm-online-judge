import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    static class Tomato {
        int x;
        int y;
        
        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<Tomato> q = new LinkedList<>();
        int unripeTomato = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new Tomato(i, j));
                } else if (map[i][j] == 0) {
                    unripeTomato++;
                }
            }
        }
        
        if (unripeTomato == 0) {
            System.out.println(0);
            return;
        }
        
        int days = 0;
        while (!q.isEmpty()) {
            Tomato current = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = map[current.x][current.y] + 1;
                        q.add(new Tomato(nextX, nextY));
                        unripeTomato--;
                        days = map[nextX][nextY];
                    }
                }
            }
        }
        
        if (unripeTomato > 0) {
            System.out.println(-1);
        } else {
            System.out.println(days - 1);
        }
    }
}