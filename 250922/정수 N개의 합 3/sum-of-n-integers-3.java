import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] temp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                temp[i][j] = temp[i-1][j] + temp[i][j-1] - temp[i-1][j-1] + arr[i-1][j-1];
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n - k + 1; i++) {      // 시작 행
            for (int j = 1; j <= n - k + 1; j++) {  // 시작 열
                int x1 = i, y1 = j;
                int x2 = i + k - 1, y2 = j + k - 1;

                int sum = temp[x2][y2]
                        - temp[x1-1][y2]
                        - temp[x2][y1-1]
                        + temp[x1-1][y1-1];

                ans = Math.max(ans, sum);
            }
        }

        System.out.println(ans);
    }
}