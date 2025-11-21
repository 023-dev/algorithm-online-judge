import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
	
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)	{
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
			int h = h1 + h2;
            if (h > 12) h -= 12;
            int m = m1 + m2;
            if (m > 59) {
                m -= 60;
                h++;
            }
            System.out.println("#" + test_case + " " + h + " " + m);
		}
	}
}