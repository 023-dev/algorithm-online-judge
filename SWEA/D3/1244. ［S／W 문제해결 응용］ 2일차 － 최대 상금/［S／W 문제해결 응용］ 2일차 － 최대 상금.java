import java.io.FileInputStream;
import java.util.*;

class Solution{
    private static int chance;
    private static boolean[][] visited;
    private static String[] arr;
    private static int max;

    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)		{
            String N = sc.next();
            arr = N.split("");
            chance = sc.nextInt();

            max = 0;

            visited = new boolean[chance+1][1_000_000];

            dfs(0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void dfs(int depth) {
        int cur = Integer.parseInt(String.join("", arr));

        if (depth == chance) {
            if (cur > max) {
                max = cur;
            }
            return;
        }

        if (visited[depth][cur]) {
            return;
        }
        visited[depth][cur] = true;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                String tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                dfs(depth+1);

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}