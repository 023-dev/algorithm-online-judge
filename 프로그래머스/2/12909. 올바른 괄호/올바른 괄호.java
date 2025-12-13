import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int opened = 0;
        for(String str : s.split("")) {
            if (str.equals("(")) {
                opened++;
            } else {
                if (opened == 0) {
                    answer = false;
                    break;
                }
                opened--;
            }
            
        }
        if (opened != 0) return false;
        return answer;
    }
}