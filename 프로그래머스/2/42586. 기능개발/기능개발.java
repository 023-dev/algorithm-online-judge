import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain + speeds[i] - 1) / speeds[i];
            q.offer(day);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int current = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= current) {
                q.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}