import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr = new int[10];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        jump(0, 0); // (현재 위치, 점프 횟수)

        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    public static void jump(int pos, int cnt) {
        // 목적지 도달
        if (pos == n - 1) {
            min = Math.min(min, cnt);
            return;
        }

        // 현재 위치에서 이동 가능한 최대 거리
        int maxJump = arr[pos];
        if (maxJump == 0) return; // 이동 불가

        // 1칸부터 arr[pos]칸까지 점프
        for (int step = 1; step <= maxJump; step++) {
            int next = pos + step;
            if (next < n) {
                jump(next, cnt + 1);
            }
        }
    }
}
