import java.util.*;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)		{
           	int N = sc.nextInt();
            int K = sc.nextInt();
            boolean[][] matrix = new boolean[N][N];
            // 단어퍼즐 초기화
            for (int i = 0; i < N; i ++) {
                for (int j = 0; j < N; j ++) {
                    matrix[i][j] = sc.nextInt() == 1 ? true : false;
                }
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                int row = 0;
            	int col = 0;
                for (int j = 0; j < N; j++) {
                    if(matrix[i][j]) { // true -> 흰칸이면 1을 더함
                        row++; 
                         if (row == K) { // 3이되면 카운트
                       	 	result++;
	                    } else if (row == K+1) { // 4가 되면 디스카운트 -> 3이 아니었다..
                       	 	result--;
                         }
                    } else { // false -> 검은색이면 다시 0부터 카운트
                        row = 0;
                    }
                    if(matrix[j][i]) {
                        col++;
                        if (col == K) {
                        	result++;
                    	} else if (col == K+1) {
                       	 	result--;
                         }
                    } else {
                        col = 0;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
		}
	}
}