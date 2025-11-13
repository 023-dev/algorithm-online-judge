import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
        if (isWin(a, b)) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
	}
    private static boolean isWin(int a, int b) {
        if (a == 1 && b == 3) {
	        return true;
        } else if (a == 2 && b == 1) {
	        return true;
        } else if (a == 3 && b == 2) {
	        return true;
        } else {
            return false;
        }
    }
}