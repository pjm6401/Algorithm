import java.util.Scanner;
public class Main {
    public static final int MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int [n+1];
        int[] numbers = new int[]{1, 2, 5};
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            for(int j = 0; j < 3; j++){
                if(i >= numbers[j])
                    dp[i] = (dp[i] + dp[i - numbers[j]]) % MOD;
            }
        }
        System.out.print(dp[n]);
    }
}