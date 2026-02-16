import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
    static char[] str1;
    static char[] str2;
    
    static int LCS() {
        int len1 = str1.length;
        int len2 = str2.length;
        int[] prev = new int[len2 + 1];
        int[] current = new int[len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    current[j] = prev[j - 1] + 1;
                } else {
                    current[j] = Math.max(prev[j], current[j - 1]);
                }
            }
            int[] temp = prev;
            prev = current;
            current = temp; // Swap 배열 (메모리 절약)
        }

        return prev[len2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        System.out.println(LCS());
    }
}
