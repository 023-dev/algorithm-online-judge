import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int food_time : food_times) {
            sum += food_time;
        }
        if (k >= sum) {
            return -1;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
        
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new int[]{food_times[i], i+1});
        }
        
        long previous = 0;
        long length = food_times.length;
        
        while (!pq.isEmpty()) {
            long current = pq.peek()[0];
            long diff = current - previous;
            
            if (diff == 0) {
                pq.poll();
                length--;
                continue;
            }
            
            long spend = diff * length;
            
            if (k >= spend) {
                k -= spend;
                previous = current;
                pq.poll();
                length--;
            } else {
                break;
            }
        }
        List<int[]> foods = new ArrayList<>(pq);
        foods.sort(Comparator.comparingInt(i -> i[1]));
        return foods.get((int) (k % length))[1];
    }
}