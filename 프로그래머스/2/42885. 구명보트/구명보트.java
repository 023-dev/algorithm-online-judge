import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int a = 0;
        int b = people.length - 1;
        
        while (a < b) {
            if (people[a] + people[b] <= limit) {
                answer++;
                a++;
            }
            b--;
        }
        return people.length - answer;
    }
}