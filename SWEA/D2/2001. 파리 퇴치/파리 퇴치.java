import java.util.*;
import java.io.FileInputStream;

class Solution{
    private static final Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws Exception{
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = initMatrix(n);
            int max = 0;            
            for (int i = 0; i <= n - m ; i++) { //n = 5, m = 3,  2
                for (int j = 0; j <= n - m; j++) { //n = 5, m = 3,  2
                    int sum = 0;
                    for (int k = i; k < i+m; k++) {//k = 2, m = 3,  5
                        for (int u = j; u < j +m; u++) {//u = 2, m = 3,  5
                            sum += matrix[k][u];
                        }
                    }
                    max = max > sum ? max : sum;
                }
            }
            System.out.println("#"+test_case + " " + max);
		}
	}
    
    private static int[][] initMatrix(int n) {
        int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();
        return matrix;
    }
}