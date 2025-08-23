import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] colUsed;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        colUsed = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int row, int sum) {
        if (row == n) {
            max = Math.max(max, sum);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!colUsed[col]) {
                colUsed[col] = true;
                dfs(row + 1, sum + grid[row][col]);
                colUsed[col] = false;
            }
        }
    }
}
