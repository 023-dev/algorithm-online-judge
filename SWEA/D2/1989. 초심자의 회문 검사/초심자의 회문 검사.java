import java.util.*;
import java.io.FileInputStream;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)	{
            int result = 1;
            String input = sc.next();
            int half = input.length()/2;
            Stack<Character> stack = new Stack();
            for (int i = 0; i < half; i++) {
                stack.push(input.charAt(i));
            }
            if (input.length() % 2 != 0) 
                half++;
            for (int i = half; i < input.length(); i++) {
                char c = stack.pop();
                if(input.charAt(i) != c) {
                    result = 0;
                    break;
                }
            }
			System.out.println("#"+test_case+" "+result);
		}
	}
}