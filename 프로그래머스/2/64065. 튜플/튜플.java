import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);

        String[] sets = s.split("\\},\\{");

        Arrays.sort(sets, Comparator.comparingInt(str -> str.split(",").length));

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (String set : sets) {
            String[] numbers = set.split(",");

            for (String number : numbers) {
                int value = Integer.parseInt(number);

                if (!visited.contains(value)) {
                    visited.add(value);
                    result.add(value);
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}