import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(print(n));
    }

    public static int print(int n){
        if(n==1){
            return 2;
        }
        if(n==2){
            return 4;
        }

        return (print(n-2)*print(n-1))%100;
    }
}