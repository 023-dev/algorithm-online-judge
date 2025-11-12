import java.util.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int sum = 0;
        for (String token : input.split("")) {
            sum += Integer.parseInt(token);
        }

        System.out.println(sum);
	}
}