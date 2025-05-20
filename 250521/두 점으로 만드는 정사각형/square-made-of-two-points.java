import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int xMinL = Math.min(x1,a1);
        int yMinL = Math.min(y1,b1);
        int xMaxR = Math.max(x2,a2);
        int yMaxR = Math.max(y2,b2);

        int max = Math.max((xMaxR-xMinL),(yMaxR-yMinL));

        System.out.print(max*max);
    }
}