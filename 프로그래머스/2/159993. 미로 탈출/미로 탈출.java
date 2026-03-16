import java.util.*;

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char c = maps[i].charAt(j);

                if (c == 'S') {
                    start = new int[]{i, j};
                }

                if (c == 'L') {
                    lever = new int[]{i, j};
                }

                if (c == 'E') {
                    exit = new int[]{i, j};
                }
            }
        }

        int toLever = bfs(start, lever, maps);

        if (toLever == -1) {
            return -1;
        }

        int toExit = bfs(lever, exit, maps);

        if (toExit == -1) {
            return -1;
        }

        return toLever + toExit;
    }

    private int bfs(int[] start, int[] target, String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});

        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {

            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int dist = now[2];

            if (x == target[0] && y == target[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}