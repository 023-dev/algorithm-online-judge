import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int computers = sc.nextInt();
        int computerLinks = sc.nextInt();
        
        boolean[][] nodes = new boolean[computers+1][computers+1];
        boolean[] visited = new boolean[computers+1];
        
        for (int i = 0; i < computerLinks; i++) {
            int node = sc.nextInt();
            int link = sc.nextInt();
            nodes[node][link] = true;
            nodes[link][node] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 1; i <= computers; i++) {
                if (nodes[cur][i]
                    && !visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                        cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}
