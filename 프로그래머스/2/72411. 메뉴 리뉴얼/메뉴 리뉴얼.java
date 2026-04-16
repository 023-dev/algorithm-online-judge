import java.util.*;

class Solution {
    private Map<String, Integer> countMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int courseSize : course) {
            countMap.clear();

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                makeCombination(chars, 0, courseSize, new StringBuilder());
            }

            int maxCount = 0;
            for (int count : countMap.values()) {
                if (count >= 2) {
                    maxCount = Math.max(maxCount, count);
                }
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxCount && maxCount >= 2) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    void makeCombination(char[] chars, int start, int targetLength, StringBuilder sb) {
        if (sb.length() == targetLength) {
            String combination = sb.toString();
            countMap.put(combination, countMap.getOrDefault(combination, 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            sb.append(chars[i]);
            makeCombination(chars, i + 1, targetLength, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}