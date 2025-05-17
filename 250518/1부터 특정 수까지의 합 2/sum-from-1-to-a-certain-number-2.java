import java.util.Scanner;

public class Main {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sum1(n));
    }

    public static int sum1(int n){
        if(n<=1) {
            return 1;
        }
        return n + sum1(n-1); 
    }
}