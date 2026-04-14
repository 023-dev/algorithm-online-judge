import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> userMap = new HashMap<>();
        StringTokenizer st;
        int resultCase = 0;
        List<String> logs = new ArrayList<>();
        for (String record : records) {
            st = new StringTokenizer(record);
            String prefix = st.nextToken();
            String userId = st.nextToken();
            
            if (prefix.equals("Enter")) {
                logs.add(userId + "님이 들어왔습니다.");
                String userName = st.nextToken();
                userMap.put(userId, userName);
                resultCase++;
            } else if (prefix.equals("Leave")) {
                logs.add(userId + "님이 나갔습니다.");
                resultCase++;
            } else { // if (prefix.equals("Change"))
                String userName = st.nextToken();
                userMap.put(userId, userName);
            }
        }
        
        String[] answer = new String[resultCase];
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String userId = log.substring(0, log.indexOf("님"));
            answer[i] = log.replace(userId, userMap.get(userId));
        }
        return answer;
    }
}