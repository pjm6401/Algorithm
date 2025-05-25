import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // A 수열 길이
        int M = sc.nextInt();  // B 수열 길이
        int[] A = new int[N];
        int[] B = new int[M];
        int MAX = 1001; // 입력값 범위 가정 (0 <= 값 <= 1000)

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < M; i++) B[i] = sc.nextInt();

        int[] bCount = new int[MAX];
        for (int i = 0; i < M; i++) {
            bCount[B[i]]++;
        }

        int cnt = 0;

        for (int i = 0; i <= N - M; i++) {
            int[] aCount = new int[MAX];
            for (int j = i; j < i + M; j++) {
                aCount[A[j]]++;
            }

            boolean same = true;
            for (int k = 0; k < MAX; k++) {
                if (aCount[k] != bCount[k]) {
                    same = false;
                    break;
                }
            }

            if (same) cnt++;
        }

        System.out.println(cnt);
    }
}
