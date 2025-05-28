import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            max = Math.max(max, h[i]);
        }

        int maxCount = 0;

        for (int seaLevel = 1; seaLevel <= max; seaLevel++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = (h[j] > seaLevel) ? 1 : 0;
            }

            // 이번 seaLevel에서의 빙하 덩어리 수
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == 1 && (j == 0 || arr[j - 1] == 0)) {
                    curCount++;
                }
            }

            maxCount = Math.max(maxCount, curCount); // 가장 큰 덩어리 수 갱신
        }

        System.out.println(maxCount);
    }
}
