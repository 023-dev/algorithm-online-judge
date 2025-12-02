import java.util.*;
import java.io.*;

public class Main {
    private static List<String> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            sb.append(isPalindrome(str)).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                if (isSpecialPalindrome(str, left+1, right)
                    || isSpecialPalindrome(str, left, right - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    private static boolean isSpecialPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}