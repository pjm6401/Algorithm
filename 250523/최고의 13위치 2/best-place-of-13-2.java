import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 2; j++) {
                int sum1 = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n - 2; l++) {
                        // 같은 행이고 겹치는 경우는 스킵
                        if (i == k && j <= l + 2 && j + 2 >= l) continue;

                        int sum2 = arr[k][l] + arr[k][l + 1] + arr[k][l + 2];
                        max = Math.max(max, sum1 + sum2);
                    }
                }
            }
        }

        System.out.print(max);
    }
}
