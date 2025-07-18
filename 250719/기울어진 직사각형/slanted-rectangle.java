import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int max = 0;
        // (i,j) = 시작 꼭짓점
        for (int i = 0; i < n-2; i++) {
            for (int j = 1; j < n-1; j++) {
                // 가능한 모든 길이 시도
                for (int len1 = 1; i + len1 < n && j - len1 >= 0; len1++) {
                    for (int len2 = 1; i + len1 + len2 < n && j + len2 < n; len2++) {
                        if (j - len1 + len2 < n && j - len1 + len2 >= 0) {
                            max = Math.max(max, getPathSum(i, j, len1, len2));
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    // i,j: 시작점, len1: 왼쪽 아래 길이, len2: 오른쪽 아래 길이
    public static int getPathSum(int i, int j, int len1, int len2) {
        int sum = 0;
        int x = i, y = j;

        // 왼쪽 아래
        for (int k = 0; k < len1; k++) {
            x++; y--;
            if (!isInBounds(x, y)) return 0;
            sum += grid[x][y];
        }

        // 오른쪽 아래
        for (int k = 0; k < len2; k++) {
            x++; y++;
            if (!isInBounds(x, y)) return 0;
            sum += grid[x][y];
        }

        // 오른쪽 위
        for (int k = 0; k < len1; k++) {
            x--; y++;
            if (!isInBounds(x, y)) return 0;
            sum += grid[x][y];
        }

        // 왼쪽 위
        for (int k = 0; k < len2; k++) {
            x--; y--;
            if (!isInBounds(x, y)) return 0;
            sum += grid[x][y];
        }

        return sum;
    }

    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
