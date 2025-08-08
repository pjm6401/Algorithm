import java.util.Scanner;
public class Main {

    static int [] memo = new int [46];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = fibo(n);

        System.out.println(result);
    }

    public static int fibo(int n){
        if(memo[m] != 0){
            return memo[n];
        }
        if(n == 1 || n==2){
            memo[n] = 1;
        }else{
            memo[n] = memo[n-1] + memo[n-2];
        }

        return memo[n];
    }
}