import java.util.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
            System.out.println("#" + test_case + " " + m/n + " " + m%n);
		}
	}
}