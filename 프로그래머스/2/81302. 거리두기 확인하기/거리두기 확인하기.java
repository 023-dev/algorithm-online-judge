import java.util.*;

class Solution {
    static final int SIZE = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = {0, 0, 0, 0, 0};
        
        for (int i = 0; i < SIZE; i++) {
            if (isSafe(places[i])) {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    
    boolean isSafe(String[] place) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!checkAround(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    boolean checkAround(String[] place, int i, int j) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                continue;
            }
            
            if (place[x].charAt(y) == 'P') {
                return false;
            }
            
            if (place[x].charAt(y) == 'O') {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
                    if (place[nx].charAt(ny) == 'P') return false;
                }
                
                if (dx[k] != 0) { 
                    if (y - 1 >= 0 && place[x].charAt(y - 1) == 'P') return false;
                    if (y + 1 < 5 && place[x].charAt(y + 1) == 'P') return false;
                } else {
                    if (x - 1 >= 0 && place[x - 1].charAt(y) == 'P') return false;
                    if (x + 1 < 5 && place[x + 1].charAt(y) == 'P') return false;
                }
            }
        }
        return true;
    }
}