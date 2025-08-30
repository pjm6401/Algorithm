import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = matrix[0][0];

        for(int i = 1; i<n; i++){
            dp[0][i] = Math.max(matrix[0][i], dp[0][i-1]);
            dp[i][0] = Math.max(matrix[i][0], dp[i-1][0]);
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<n; j++){
                dp[i][j] = Math.min(Math.max(matrix[i][j], dp[i-1][j]), Math.max(matrix[i][j], dp[i][j-1]));
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}