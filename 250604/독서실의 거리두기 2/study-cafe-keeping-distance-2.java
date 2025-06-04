import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        int[] arr = new int[N];

        for (int i = 0; i < seats.length(); i++) {
            if (seats.charAt(i) == '1') arr[i] = 1;
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) continue;

            arr[i] = 1;  // 사람을 앉힌다
            int prev = -1;
            int localMin = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (arr[j] == 1) {
                    if (prev != -1) {
                        localMin = Math.min(localMin, j - prev);
                    }
                    prev = j;
                }
            }

            result = Math.max(result, localMin);  // 최적의 최소 거리 최대값
            arr[i] = 0; // 원상복구
        }

        System.out.println(result);
    }
}
