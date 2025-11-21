import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)		{
			int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                StringBuffer sb3 = new StringBuffer();
                for(int j = 0; j < N; j++) {
                    sb1.append(matrix[N-1-j][i]);
                    sb2.append(matrix[N-1-i][N-1-j]);
                    sb3.append(matrix[j][N -1 -i]);
                }
                System.out.println(sb1 + " " + sb2 + " " + sb3);
            }
		}
	}
}