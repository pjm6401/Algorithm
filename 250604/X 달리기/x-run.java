import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(); // 목표 거리

        int speed = 0;
        int distance = 0;
        int time = 0;

        while (true) {
            // 남은 거리 계산
            int remain = X - distance;

            // 도착 조건: 도착 거리이고 속도 1이면 완료
            if (remain == 0 && speed == 1) break;

            // 속도를 줄였을 때, 도착까지 정확히 맞출 수 있는 최소 거리 계산
            int slowDownDistance = (speed * (speed + 1)) / 2;

            if (remain > slowDownDistance) {
                speed++;
            } else if (remain < slowDownDistance) {
                if (speed > 1) speed--;
            }
            // else : 그대로 유지

            distance += speed;
            time++;

            // 안전장치: 루프가 너무 길어질 경우 종료 (비정상)
            if (time > 100000) {
                System.out.println("시간 초과 (비정상 동작)");
                return;
            }
        }

        System.out.println(time);
    }
}
