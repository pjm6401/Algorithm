import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int disAtoB = Math.abs(B-A);
        int disAtoXtoB = Math.abs(x-A) + Math.abs(B-y);
        int disAtoYtoB = Math.abs(y-A) + Math.abs(B-x);

        int min = Math.min(disAtoB,Math.min(disAtoXtoB,disAtoYtoB));
        System.out.println(min);
    }
}