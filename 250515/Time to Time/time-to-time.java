import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int aMin = (a*60) + b;

        int bMin = (c*60) + d;

        System.out.println(bMin-aMin);
    }
}