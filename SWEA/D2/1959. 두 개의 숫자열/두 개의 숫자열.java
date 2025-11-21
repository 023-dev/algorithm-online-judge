import java.util.*;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)	{
			int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }
            int[] longArr = N > M ? A : B;
            int[] shortArr = N < M ? A : B;
            
 
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= longArr.length - shortArr.length; i++) {
                int sum = 0;
                for (int j = 0; j < shortArr.length; j++) {
                    sum += shortArr[j] * longArr[i+j];
                }
                if (sum > max) {
                    max = sum;
                }
            }
            System.out.println("#" + test_case + " " + max);
		}
	}
}