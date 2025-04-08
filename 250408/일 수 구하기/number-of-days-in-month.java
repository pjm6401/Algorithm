import java.util.*;

public class Main {

    private static final int [] year = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();

        System.out.print(year[month-1]);
    }
}