class Solution {
    public int solution(int[] numbers, int target) {
        // 깊이(index) 0, 현재 합계(sum) 0에서 시작
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        // 1. 탈출 조건 (Base Case): 모든 숫자를 다 탐색했을 때
        if (depth == numbers.length) {
            // 현재까지의 합이 타겟과 같으면 1(성공), 아니면 0(실패) 반환
            return sum == target ? 1 : 0;
        }

        // 2. 수행 동작 (Recursive Step):
        // 현재 숫자를 '더하는 경우'와 '빼는 경우'를 각각 재귀 호출하고 결과를 합산
        return dfs(numbers, target, depth + 1, sum + numbers[depth]) 
             + dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}