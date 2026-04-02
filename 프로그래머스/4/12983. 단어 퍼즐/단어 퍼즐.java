import java.util.*;

class Solution {
    public int solution(String[] strings, String target) {
        int[] dp = new int[target.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        Set<String> set = new HashSet<>(Arrays.asList(strings));
        
        for (int i = 1; i <= target.length(); i++) {
            for (String string : strings) {
                int len = string.length();
                
                if (i - len >= 0) {
                    String sub = target.substring(i - len, i);
                    
                    if (set.contains(sub) && dp[i - len] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - len] + 1);
                    }
                }
            }
        }
        
        return dp[target.length()] == Integer.MAX_VALUE ? -1 : dp[target.length()];
    }
}