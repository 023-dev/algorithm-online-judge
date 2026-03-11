import java.util.*;

class Solution {
    public int solution(int k, int[] tangerines) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int tangerine : tangerines) {
            int count = countMap.getOrDefault(tangerine, 0) + 1;
            countMap.put(tangerine, count);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());

        int answer = 0;
        int sum = 0;

        for (int count : counts) {
            sum += count;
            answer++;

            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}