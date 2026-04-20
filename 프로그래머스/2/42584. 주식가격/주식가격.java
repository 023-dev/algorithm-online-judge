import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int topIndex = stack.pop();
                answer[topIndex] = i - topIndex;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            answer[topIndex] = n - 1 - topIndex;
        }

        return answer;
    }
}