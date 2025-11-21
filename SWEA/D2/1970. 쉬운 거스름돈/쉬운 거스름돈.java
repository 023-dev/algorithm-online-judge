import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
        int[] units = {50_000,10_000,5_000,1_000,500,100,50,10};
        int[] excs = {0,0,0,0,0,0,0,0};
		for(int test_case = 1; test_case <= T; test_case++)	{
            int N = sc.nextInt();
			for(int i = 0; i < units.length; i++) {
                excs[i] = N/units[i];
                N %= units[i];
            }
            System.out.println("#"+test_case);
            for (int exc : excs) {
                System.out.print(exc + " ");
            }
            System.out.println();
		}
	}
}