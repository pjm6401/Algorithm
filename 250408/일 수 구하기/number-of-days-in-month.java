import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] year = {31,28,31,30,31,30,31,31,30,31,30,31};

        int month = sc.nextInt();

        System.out.print(year[month-1]);
    }
}