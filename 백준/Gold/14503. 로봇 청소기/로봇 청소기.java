import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2; 
                answer++;
            }

            boolean hasUncleaned = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isOutBound(nr,nc) && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    hasUncleaned = true;
                    break;
                }
            }

            // 2. 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!hasUncleaned) {
                int nd = (d + 2) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (!isOutBound(nr,nc) && map[nr][nc] != 1) {
                    r = nr;
                    c = nc;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    
    static boolean isOutBound(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }
    
    //boolean hasUncleaned(int r, int c) {
    //}
}