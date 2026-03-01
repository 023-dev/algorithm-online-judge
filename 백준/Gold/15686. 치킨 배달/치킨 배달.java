import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) houses.add(new int[]{i, j});
                if (value == 2) chickens.add(new int[]{i, j});
            }
        }

        combination(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    static void combination(int start, int depth, List<int[]> selected) {
        if (depth == M) {
            answer = Math.min(answer, calculate(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(i + 1, depth + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    static int calculate(List<int[]> selected) {
        int sum = 0;

        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;

            for (int[] chicken : selected) {
                int dist = Math.abs(house[0] - chicken[0])
                        + Math.abs(house[1] - chicken[1]);
                minDist = Math.min(minDist, dist);
            }

            sum += minDist;
        }

        return sum;
    }
}