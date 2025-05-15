import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개발자 수
        int K = sc.nextInt(); // 전염 가능 횟수
        int P = sc.nextInt(); // 최초 감염자
        int T = sc.nextInt(); // 악수 횟수

        boolean[] infected = new boolean[N + 1];       // 감염 여부 (1번부터 사용)
        int[] infectCount = new int[N + 1];            // 전염 가능 횟수

        infected[P] = true;
        infectCount[P] = K;

        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); // 시간
            shakes[i][1] = sc.nextInt(); // A
            shakes[i][2] = sc.nextInt(); // B
        }

        Arrays.sort(shakes, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < T; i++) {
            int time = shakes[i][0];
            int a = shakes[i][1];
            int b = shakes[i][2];

            boolean aCanInfect = infected[a] && infectCount[a] > 0;
            boolean bCanInfect = infected[b] && infectCount[b] > 0;

            // 감염 여부 갱신
            if (aCanInfect && !infected[b]) {
                infected[b] = true;
                infectCount[b] = K;
            }
            if (bCanInfect && !infected[a]) {
                infected[a] = true;
                infectCount[a] = K;
            }

            // 감염자라면 전염 횟수 차감 (서로 감염자여도 각각 차감)
            if (infected[a] && infectCount[a] > 0) infectCount[a]--;
            if (infected[b] && infectCount[b] > 0) infectCount[b]--;
        }

        // 출력: 1이면 감염, 0이면 비감염
        for (int i = 1; i <= N; i++) {
            System.out.print(infected[i] ? "1" : "0");
        }
    }
}
