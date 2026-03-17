import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
        int k = Integer.parseInt(st.nextToken()); // 연속 선택 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[n];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>(k);
        int max = 0;

        for (int i = 0; i < k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }

        max = map.size() + (map.containsKey(c) ? 0 : 1);

        for (int i = 1; i < n; i++) {

            int left = sushi[i - 1];
            map.put(left, map.get(left) - 1);

            if (map.get(left) == 0) {
                map.remove(left);
            }

            int right = sushi[(i + k - 1) % n];
            map.put(right, map.getOrDefault(right, 0) + 1);

            int current = map.size();
            if (!map.containsKey(c)) {
                current++;
            }

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}