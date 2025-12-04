import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> tops = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!tops.isEmpty()) {
                if (tops.peek().height < height) {
                    tops.pop();
                } else {
                    sb.append(tops.peek().position).append(" ");
                    break;
                }
            }
            if (tops.isEmpty()) {
                sb.append("0 ");
            }
            tops.push(new Top(i, height));
        }
        System.out.println(sb);
    }

    private static class Top {
        int position;
        int height;

        public Top (int position, int height) {
            this.position = position;
            this.height = height;
        }
    }
}