class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        int answer = 0;
        
        for (int stone : stones) {
            right = Math.max(right, stone);
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canOver(stones, mid, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean canOver(int[] stones, int mid, int stepLimit) {
        int step = 0;
        
        for (int stone : stones) {
            if (stone >= mid) {
                step = 0;
            } else {
                step++;
                if (step >= stepLimit) {
                    return false;
                }
            }
        }
        return true;
    }
}