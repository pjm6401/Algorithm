import java.util.Scanner;

public class Main {

    public static int circularDiff(int x, int y, int n) {
        int diff = Math.abs(x - y);
        return Math.min(diff, n - diff); // 원형 거리
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 자물쇠 숫자 범위
        int a = sc.nextInt(); // 첫 번째 조합
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt(); // 두 번째 조합
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    boolean firstCombo =
                            circularDiff(a, i, n) <= 2 &&
                            circularDiff(b, j, n) <= 2 &&
                            circularDiff(c, k, n) <= 2;

                    boolean secondCombo =
                            circularDiff(a2, i, n) <= 2 &&
                            circularDiff(b2, j, n) <= 2 &&
                            circularDiff(c2, k, n) <= 2;

                    if (firstCombo || secondCombo) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
