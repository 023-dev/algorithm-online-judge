import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        // 1, 2, 3, 4, 5, 6, 7
        // 1, 2, 4, 5, 6, 7 -> 3
        // 1, 2, 4, 5, 7 -> 3, 6
        // 1, 4, 5, 7 -> 3, 6, 2
        // 1, 4, 5 -> 3, 6, 2, 7
        // 1, 4 -> 3, 6, 2, 7, 5
        // 4 -> 3, 6, 2, 7, 5, 1
        // -> 3, 6, 2, 7, 5, 1, 4

        List<Integer> removes = new ArrayList<>();
        StringBuffer sb = new StringBuffer("<");
        int next = K - 1;
        while (!numbers.isEmpty()) {
            Integer number = numbers.remove(next);
            if (!numbers.isEmpty()) {
                next = (next + K - 1) % numbers.size();
                sb.append(number).append(", ");
            } else {
                sb.append(number).append(">");
            }
        }
        System.out.println(sb);
    }
}