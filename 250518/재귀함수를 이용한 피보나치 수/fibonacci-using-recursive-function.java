import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(result(n));
    }

    public static int result(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;

        return result(n-1)+result(n-2);
            
    }
}