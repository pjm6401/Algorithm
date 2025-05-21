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

        // 첫 번째: 이동 범위를 계산
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            xs[i] = x;
            dirs[i] = dir;

            if (dir == 'R') {
                pos += x;
            } else {
                pos -= x;
            }

            min = Math.min(min, pos);
            max = Math.max(max, pos);
        }

        int offset = -min; // 음수 좌표를 양수 인덱스로 보정
        int size = max - min + 1; // 포함된 모든 칸을 담기 위한 사이즈
        int[] visited = new int[size];

        int curr = offset;

        // 두 번째: 실제 이동 경로를 기록
        for (int i = 0; i < N; i++) {
            int x = xs[i];
            char dir = dirs[i];

            for (int j = 0; j < x; j++) {
                if (dir == 'R') {
                    visited[curr]=2;
                    curr++;
                } else {
                    curr--;
                    visited[curr]=3;
                }
            }
        }

        // 세 번째: 두 번 이상 지난 칸 수를 카운트
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < size; i++) {
            if (visited[i] == 2) count1++;
            if (visited[i] == 3) count2++;
        }

        System.out.println(count2+" "+count1);
    }
}