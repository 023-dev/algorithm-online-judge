import java.util.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
            int A = sc.nextInt(); 
            int B = sc.nextInt(); 
            int N = sc.nextInt();
            int cnt = 0;
            int max = A > B ? A : B;
            int min = A < B ? A : B;
            int tmp = 0;
            while (max <= N) {
                min += max;
                cnt++;
                tmp = min;
                min = max;
                max = tmp;
            }
            System.out.println(cnt);
		}
    }
}