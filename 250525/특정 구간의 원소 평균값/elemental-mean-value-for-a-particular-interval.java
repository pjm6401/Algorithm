import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                int len = j - i + 1;

                // 평균이 정수인지 확인
                if (sum % len != 0)
                    continue;

                int mean = sum / len;

                // 해당 구간 안에 평균값이 존재하는지 확인
                for (int k = i; k <= j; k++) {
                    if (arr[k] == mean) {
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
