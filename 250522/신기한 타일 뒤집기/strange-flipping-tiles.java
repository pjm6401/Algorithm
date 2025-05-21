import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] xs = new int[N];
        char[] dirs = new char[N];

        int pos = 0;
        int min = 0;
        int max = 0;

        // 1. 위치 범위 계산
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            xs[i] = x;
            dirs[i] = dir;

            if (dir == 'R') {
                max = Math.max(max, pos + x - 1);
                pos = pos + x - 1;
            } else {
                min = Math.min(min, pos - (x - 1));
                pos = pos - (x - 1);
            }
        }

        int offset = -min; // 음수 인덱스 방지
        int size = max - min + 1;
        int[] tiles = new int[size]; // 0 = 회색, 1 = 검정, -1 = 흰색

        // 2. 실제 명령 수행
        int curr = offset;
        for (int i = 0; i < N; i++) {
            int x = xs[i];
            char dir = dirs[i];

            if (dir == 'R') {
                for (int j = 0; j < x; j++) {
                    tiles[curr + j] = 1; // 검정색
                }
                curr = curr + x - 1; // 마지막 위치로 이동
            } else {
                for (int j = 0; j < x; j++) {
                    tiles[curr - j] = -1; // 흰색
                }
                curr = curr - x + 1; // 마지막 위치로 이동
            }
        }

        // 3. 흰색/검정색 개수 세기
        int white = 0;
        int black = 0;
        for (int color : tiles) {
            if (color == -1) white++;
            else if (color == 1) black++;
        }

        System.out.println(white + " " + black);
    }
}
