import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemMap = new HashMap<>();

        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        String key = null;
        int[] answer = new int[2];
        while (true) {
            if (gemMap.size() == gemSet.size()) {
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start+1;
                    answer[1] = end;
                }
                key = gems[start];
                gemMap.put(key, gemMap.get(key) - 1);
                
                if (gemMap.get(key) == 0) {
                    gemMap.remove(key);
                }
                start++;
            } else if (end == gems.length) {
                break;
            } else {
                key = gems[end];
                gemMap.put(key, gemMap.getOrDefault(key, 0) + 1);
                end++;
            }
        }
        return answer;
    }
}