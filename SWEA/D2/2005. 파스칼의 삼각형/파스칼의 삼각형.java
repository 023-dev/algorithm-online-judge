import java.util.*;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
            System.out.println("#"+t);
			int n = sc.nextInt();
            if (n == 1) {
                System.out.print("1");
                break;
            }
            int[][] pTriangle = new int[n][n];
            StringBuilder result = new StringBuilder();
            Arrays.fill(pTriangle[0], 0);
            pTriangle[0][0] = 1;
            result.append(pTriangle[0][0] + "\n");
            
            for (int i = 1; i < n; i++) {
           		Arrays.fill(pTriangle[i], 0);
                pTriangle[i][0] = 1;
                result.append(pTriangle[i][0] + " ");
				for (int j = 1;j < i+1; j++) {
                    pTriangle[i][j] = pTriangle[i-1][j-1] + pTriangle[i-1][j];
                    result.append(pTriangle[i][j] + " ");
                }
                result.append("\n");
            }   
            System.out.print(result);
		}
	}
}