import java.util.Scanner;

public class Main {

    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(getSeasonOrInvalid(y, m, d));
    }

    public static String getSeasonOrInvalid(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1) {
            return "-1";
        }

        int maxDay = daysInMonth[month - 1];

        // 윤년이면 2월 29일까지 허용
        if (isLeapYear(year) && month == 2) {
            maxDay = 29;
        }

        if (day > maxDay) {
            return "-1";
        }

        return getSeason(month);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getSeason(int month) {
        if (month >= 3 && month <= 5) {
            return "Spring";
        } else if (month >= 6 && month <= 8) {
            return "Summer";
        } else if (month >= 9 && month <= 11) {
            return "Fall";
        } else { // 12, 1, 2
            return "Winter";
        }
    }
}
