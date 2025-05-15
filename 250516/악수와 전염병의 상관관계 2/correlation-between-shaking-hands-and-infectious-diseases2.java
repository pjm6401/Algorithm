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

            if(infected[a]){
                infectCount[a]++; 
            }

            if(infected[b]){
                infectCount[b]++;
            }
            if(infectCount[a]<=K && infected[a]){
                infected[b] = true;
            }

            if(infectCount[b]<=K && infected[b]){
                infected[a] = true;
            }
        }

        // 출력: 1이면 감염, 0이면 비감염
        for (int i = 1; i <= N; i++) {
            System.out.print(infected[i] ? "1" : "0");
        }
    }
}
