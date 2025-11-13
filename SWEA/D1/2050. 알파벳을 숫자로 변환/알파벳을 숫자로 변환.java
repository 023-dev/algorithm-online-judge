import java.util.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
        int[] array = new int[input.length()];
        for (int i = 0; i < array.length; i++) {
        	char c = input.charAt(i);
            System.out.print((int) c-64 +" ");
        }
	}
}