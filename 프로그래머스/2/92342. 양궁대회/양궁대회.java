import java.util.*;

class Solution {
    
    int maxDiff = -1;
    int[] answer = new int[11];
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        
        if (maxDiff == -1) return new int[]{-1};
        return answer;
    }
    
    private void dfs(int idx, int remain, int[] lion, int[] info) {
        if (idx == 11) {
            lion[10] += remain;
            
            int diff = calcDiff(lion, info);
            
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = lion.clone();
                } else if (diff == maxDiff) {
                    if (isBetter(lion, answer)) {
                        answer = lion.clone();
                    }
                }
            }
            
            lion[10] -= remain;
            return;
        }
        
        int need = info[idx] + 1;
        if (remain >= need) {
            lion[idx] = need;
            dfs(idx + 1, remain - need, lion, info);
            lion[idx] = 0;
        }
        
        dfs(idx + 1, remain, lion, info);
    }
    
    private int calcDiff(int[] lion, int[] info) {
        int lionScore = 0;
        int apeachScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (lion[i] == 0 && info[i] == 0) continue;
            
            if (lion[i] > info[i]) {
                lionScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }
        
        return lionScore - apeachScore;
    }
    
    private boolean isBetter(int[] lion, int[] prev) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > prev[i]) return true;
            else if (lion[i] < prev[i]) return false;
        }
        return false;
    }
}