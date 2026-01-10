import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            Integer value = map.get(name);
            if (value == null) {
                map.put(name, 1);
            } else {
                map.put(name, ++value);
            }
        }
        
        for (String name : completion) {
            Integer value = map.get(name);
            map.put(name, --value);
        }
        
        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                answer = name;
                break;
            }
        }
        
        return answer;
    }
}