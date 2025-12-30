import java.util.*;
import java.io.*;

public class Main {
    private static int[] time = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N, K);
        }
    }
    
    private static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nextMoves = {now - 1, now + 1, now * 2};

            for (int next : nextMoves) {
                if (next == target) {
                    System.out.println(time[now]);
                    return;
                }
                if (next >= 0 && next <= 100000 && time[next] == 0) {
                    time[next] = time[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}