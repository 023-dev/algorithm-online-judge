class Solution {

    int n, m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;

        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    int dfs(int[][] board, int ax, int ay, int bx, int by) {

        if (board[ax][ay] == 0) return 0;

        int result = 0;

        for (int d = 0; d < 4; d++) {

            int nx = ax + dx[d];
            int ny = ay + dy[d];

            if (!isValid(nx, ny) || board[nx][ny] == 0) continue;

            board[ax][ay] = 0;

            int turn = dfs(board, bx, by, nx, ny) + 1;

            board[ax][ay] = 1;

            if (result % 2 == 0 && turn % 2 == 1) {
                result = turn;
            } 
            else if (result % 2 == 0 && turn % 2 == 0) {
                result = Math.max(result, turn);
            } 
            else if (result % 2 == 1 && turn % 2 == 1) {
                result = Math.min(result, turn);
            }
        }

        return result;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}