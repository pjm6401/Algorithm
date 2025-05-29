import java.util.Scanner;

public class Main {
    static int n;
    static int[] x = new int[20];
    static int[] y = new int[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // x축 선분 0~3개 선택
        for (int x1 = -1; x1 <= 20; x1++) {
            for (int x2 = -1; x2 <= 20; x2++) {
                for (int x3 = -1; x3 <= 20; x3++) {
                    // 중복 제거
                    if (!isValid(x1, x2, x3)) continue;

                    // y축 선분 0~3개 선택
                    for (int y1 = -1; y1 <= 20; y1++) {
                        for (int y2 = -1; y2 <= 20; y2++) {
                            for (int y3 = -1; y3 <= 20; y3++) {
                                if (!isValid(y1, y2, y3)) continue;

                                // 총 선분 개수가 3개 이하여야 함
                                int xCount = countValid(x1, x2, x3);
                                int yCount = countValid(y1, y2, y3);
                                if (xCount + yCount > 3) continue;

                                if (canCoverAll(x1, x2, x3, y1, y2, y3)) {
                                    System.out.println(1);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean isValid(int a, int b, int c) {
        // -1은 선택 안 한 상태로 간주 (중복 허용 안 함)
        if ((a != -1 && a == b) || (a != -1 && a == c) || (b != -1 && b == c)) return false;
        return true;
    }

    static int countValid(int a, int b, int c) {
        int count = 0;
        if (a != -1) count++;
        if (b != -1) count++;
        if (c != -1) count++;
        return count;
    }

    static boolean canCoverAll(int x1, int x2, int x3, int y1, int y2, int y3) {
        for (int i = 0; i < n; i++) {
            boolean covered = false;
            if (x[i] == x1 || x[i] == x2 || x[i] == x3) covered = true;
            if (y[i] == y1 || y[i] == y2 || y[i] == y3) covered = true;
            if (!covered) return false;
        }
        return true;
    }
}
