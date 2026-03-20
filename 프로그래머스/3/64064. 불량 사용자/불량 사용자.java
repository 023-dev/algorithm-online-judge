import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, new HashSet<>());
        return result.size();
    }
    
    void dfs(String[] user_id, String[] banned_id, int depth, Set<String> current) {
        if(depth == banned_id.length) {
            result.add(new HashSet<>(current));
            return;
        }
    
        String banPattern = banned_id[depth];
        for (String userId : user_id) {
            if (current.contains(userId)) continue;
            if (isMatch(userId, banPattern)) {
                current.add(userId);
                dfs(user_id, banned_id, depth+1, current);
                current.remove(userId);
            }
        }
    }
    
    boolean isMatch(String user, String pattern) {
        if (user.length() != pattern.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (pattern.charAt(i) == '*') continue;
            if (user.charAt(i) != pattern.charAt(i)) return false;
        }
        
        return true;
    }
}