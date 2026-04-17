class Solution {
    static int distance;
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static char[] dir = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        distance = Math.abs(x - r) + Math.abs(y - c);
        
        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }
        StringBuilder answer = new StringBuilder();
        
        int cr = x;
        int cc = y;
        int count = k;
        while (count > 0) {
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + cr;
                int nc = dc[i] + cc;
                
                if (nr < 1 || nr > n || nc < 1 || nc > m) {
                    continue;
                }
                
                int dist = Math.abs(nr - r) + Math.abs(nc - c);
                int nextK = count - 1;
                
                if (dist <= nextK
                   && (nextK - dist) % 2 == 0) {
                    answer.append(dir[i]);
                    cr = nr;
                    cc = nc;
                    count--;
                    break;
                }
            }
        }
         
        return answer.toString();
    }
}