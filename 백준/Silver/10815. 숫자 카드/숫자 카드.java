import java.util.*;

public class Main {
    private static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        int M = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            sb.append(search(target)).append(" ");
        }
        System.out.println(sb);
    }

    static int search(int target) {
        int min = 0;
        int max = numbers.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (numbers[mid] > target) {
                max = mid - 1;
            } else if (numbers[mid] < target){
                min = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}