import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
	        String input = sc.next();
	        String year = input.substring(0,4);
            String month = input.substring(4,6);
            String day = input.substring(6,8);
            if (isDate(month, day)) {
	    	    System.out.println("#" + (t+1) + " " + year + "/" + month + "/" +day);
            } else {
                System.out.println("#" + (t+1) + " -1");
            }
        }
	}
    private static boolean isDate(String month, String day) {
		int monthNumber = Integer.parseInt(month); 
        if (monthNumber < 1 || monthNumber > 12) 
            return false;
        int dayNumber = Integer.parseInt(day); 
        if (dayNumber < 1 || dayNumber > 31)
            return false;
        if (monthNumber == 2)
            return dayNumber <= 28;
        if (has31Days(monthNumber)) {
            return dayNumber <= 31;
        } else {
            return dayNumber <= 30;
        }
    }
    private static boolean has31Days(int month) {
        if (month <= 7) {
            if (isOdd(month))
                return true;
        } else {
            if (!isOdd(month))
                return true;
        }
        return false;  
    }
    private static boolean isOdd(int number) {
        return number% 2 != 0;
    }
}