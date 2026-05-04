import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int fatigue, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(fatigue, dungeons, 0);
        return answer;
    }
    
    void dfs (int fatigue, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int required = dungeons[i][0];
            int consume = dungeons[i][1];
            
            if (!visited[i] && fatigue >= required) {
                visited[i] = true;
                dfs(fatigue - consume, dungeons, count+1);
                visited[i] = false;
            }
        }
    }
}