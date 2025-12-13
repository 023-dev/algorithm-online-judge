import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int price : prices) {
            q.offer(price);
        }
        
        int index = 0;
        while (!q.isEmpty()) {
            int curPrice = q.poll();
            int fall_period = 0;
            for (int nextPrice : q) {
                if (nextPrice >= curPrice) {
                    fall_period++;
                } else {
                    fall_period++;
                    break;
                }
            }
            answer[index++] = fall_period;
        }
        
        return answer;
    }
}