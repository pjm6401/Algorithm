import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            profit[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) { // i: 카드팩 크기
            for (int j = i; j <= n; j++) { // j: 총 카드 수
                dp[j] = Math.max(dp[j], dp[j-i] + profit[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
