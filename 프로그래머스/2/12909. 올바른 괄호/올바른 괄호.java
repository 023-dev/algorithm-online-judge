import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int is_opened = 0;
        for (String str : s.split("")) {
            if (str.equals("(")) is_opened++;
            else {
                if (is_opened == 0) {
                    answer = false;
                    break;
                }
                is_opened--;  
            } 
        }
        if (is_opened != 0) return false;
        return answer;
    }
}