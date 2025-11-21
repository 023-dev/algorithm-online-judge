import java.util.*;
import java.util.*;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)		{
			int[][] matrix = new int[9][9];
            for (int i = 0; i < 9; i++) 
                for (int j = 0; j < 9; j++)
                    matrix[i][j] = sc.nextInt();
            
            boolean isValid = false;
            for (int i = 0; i < 9; i++) {
                Set<Integer> unqRow = new HashSet<Integer>();
                Set<Integer> unqCol = new HashSet<Integer>();
                for (int j = 0; j < 9; j++) {
                    unqRow.add(matrix[i][j]);
                	unqCol.add(matrix[j][i]);
                }
                if(unqRow.size() != 9 
                  || unqCol.size() != 9) {
                    isValid = true;
                    break;
                }
            }

            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    Set<Integer> unqSqr = new HashSet<Integer>();
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
		                    unqSqr.add(matrix[i+r][j+c]);
                        }
                    }
                    if(unqSqr.size() != 9 ) {
                        isValid = true;
                        break;
                    }
                }
            }
                
            if(isValid) {
            	System.out.println("#" + test_case + " 0");
            } else {
            	System.out.println("#" + test_case + " 1");
            }
		}
	}
}