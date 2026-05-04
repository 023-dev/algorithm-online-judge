class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    void dfs (int current, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int[] next = dungeons[i];
            int required = next[0];
            int consume = next[1];
            
            if (!visited[i] && current >= required) {
                visited[i] = true;
                dfs(current - consume, dungeons, count+1);
                visited[i] = false;
            }
        }
    }
}