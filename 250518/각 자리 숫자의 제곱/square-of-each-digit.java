import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(result(n));
    }

    public static int result(int n){
        if(n<10){
            return n*n;
        }

        return (n%10)*(n%10) + result(n/10);
    }
}