import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, Integer> memo = new HashMap<>();

    public static int dfs(int distance, int speed) {
        if (distance < 0 || speed <= 0) return Integer.MAX_VALUE / 2; // invalid
        if (distance == 0 && speed == 1) return 0;

        String key = distance + "," + speed;
        if (memo.containsKey(key)) return memo.get(key);

        int min = Integer.MAX_VALUE / 2;

        // try speed-1, speed, speed+1
        for (int dSpeed = -1; dSpeed <= 1; dSpeed++) {
            int nextSpeed = speed + dSpeed;
            if (nextSpeed <= 0) continue;
            min = Math.min(min, 1 + dfs(distance - nextSpeed, nextSpeed));
        }

        memo.put(key, min);
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        // 초기 속도 0 -> 다음 속도 1부터 시작해야 함
        int answer = dfs(X - 1, 1) + 1; // 처음 1m/s로 이동 후 탐색 시작
        System.out.println(answer);
    }
}
