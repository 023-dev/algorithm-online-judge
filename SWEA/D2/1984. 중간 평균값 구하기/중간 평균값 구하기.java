import java.util.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)		{
			int[] numbers = new int[10];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextInt();
            }
			numbers = Arrays.stream(numbers).sorted().toArray();
            int sum = 0;
            for (int i = 1; i < numbers.length - 1; i++) {
                sum += numbers[i];
            }
            System.out.println("#" + test_case + " " + Math.round(((float) sum) /8));
		}
	}
}