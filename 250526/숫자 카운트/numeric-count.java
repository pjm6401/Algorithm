import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        int count = 0;
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                if (x == y) continue;
                for (int z = 1; z < 10; z++) {
                    if (x == z || y == z) continue;

                    boolean isValid = true;

                    for (int i = 0; i < n; i++) {
                        int num1 = num[i] / 100;
                        int num2 = (num[i] / 10) % 10;
                        int num3 = num[i] % 10;

                        int strike = 0;
                        int ball = 0;

                        // 스트라이크 판별
                        if (x == num1) strike++;
                        if (y == num2) strike++;
                        if (z == num3) strike++;

                        // 볼 판별 (위에서 스트라이크가 아닌 경우만 고려)
                        if (x == num2 || x == num3) ball++;
                        if (y == num1 || y == num3) ball++;
                        if (z == num1 || z == num2) ball++;

                        if (strike != count1[i] || ball != count2[i]) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        // 유효한 숫자 조합
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}