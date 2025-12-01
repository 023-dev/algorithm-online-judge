import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> primes = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            if (i < 2) continue;
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(i);
        }
        for (Integer prime : primes) {
            System.out.println(prime);
        }
    }
}