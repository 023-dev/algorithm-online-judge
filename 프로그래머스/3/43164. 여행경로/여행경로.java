import java.util.*;

class Solution {
    boolean[] visited;
    List<String> result;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) 
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", "ICN", tickets, path, 0);
        
        return result.toArray(new String[0]);
    }
    
    boolean dfs(String current, String start, String[][] tickets, List<String> path, int usedCount) {
        if (usedCount == tickets.length) {
            result = new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], start, tickets, path, usedCount+1)) {
                    return true;
                }
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        } 
        return false;
    }
}