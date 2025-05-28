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


            // 이번 seaLevel에서의 빙하 덩어리 수
            int cnt = 0;

            if(h[0]-seaLevel>0) cnt++;
            for (int j = 1; j < n; j++) {
                if (h[j] - seaLevel>0 && h[j-1] -seaLevel <= 0) {
                    cnt++;
                }
            }

            maxCount = Math.max(maxCount, cnt); // 가장 큰 덩어리 수 갱신
        }

        System.out.println(maxCount);
    }
}
