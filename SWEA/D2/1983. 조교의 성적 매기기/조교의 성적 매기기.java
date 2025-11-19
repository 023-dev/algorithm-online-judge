import java.util.*;
import java.io.FileInputStream;

class Solution{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            double[] scores = new double[N];
            for (int i = 0; i < N; i++) {
                double score = sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2;
                scores[i] = score;
            }
            double[] avg = Arrays.stream(scores).sorted().toArray();
            String[] student = new String[N];
            for (int i = 0; i < N; i++) {
                String result;
                if (scores[i] >= avg[N*9  / 10]) {
                    result = "A+";
                } else if (scores[i] >= avg[N*8  / 10]) {
                    result = "A0";
                } else if (scores[i] >= avg[N*7  / 10]) {
                    result = "A-";
                } else if (scores[i] >= avg[N*6  / 10]) {
                    result = "B+";
                } else if (scores[i] >= avg[N*5  / 10]) {
                    result = "B0";
                } else if (scores[i] >= avg[N*4  / 10]) {
                    result = "B-";
                } else if (scores[i] >= avg[N*3  / 10]) {
                    result = "C+";
                } else if (scores[i] >= avg[N*2  / 10]) {
                    result = "C0";
                } else if (scores[i] >= avg[N*1  / 10]) {
                    result = "C-";
                } else {
                    result = "D0";
                }
                student[i] = result;
            }
            System.out.println("#"+test_case+" "+ student[K-1]);
        }
    }
}