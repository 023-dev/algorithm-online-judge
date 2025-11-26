import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] trees = new long[N];
        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextLong();
        }
        Arrays.sort(trees);

        long min = 0;
        long max = trees[N-1];
        long H = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long amount = 0;

            for (int i = 0; i < N; i++) {
                if(trees[i] > mid) amount += trees[i] - mid;
            }
            
            if (amount >= M) {
                H = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(H);
    }
}