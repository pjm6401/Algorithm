import java.util.Scanner;

public class Main {
    static int[] temp = new int[101];
    static int[] bombs = new int[101];
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        boolean flag = true;
        int length = n;

        while (flag) {
            flag = false;
            int index = 0;

            // 0 제거하고 앞으로 당김
            for (int i = 0; i < length; i++) {
                if (bombs[i] != 0) {
                    temp[index++] = bombs[i];
                }
            }

            // temp -> bombs 복사
            for (int i = 0; i < index; i++) {
                bombs[i] = temp[i];
            }

            length = index;
            temp = new int[101];

            // 연속된 숫자 탐색 및 제거
            int i = 0;
            while (i < length) {
                int j = i + 1;
                while (j < length && bombs[i] == bombs[j]) j++;
                int count = j - i;
                if (count >= m) {
                    for (int k = i; k < j; k++) {
                        bombs[k] = 0;
                    }
                    flag = true;
                }
                i = j;
            }
        }

        // 최종 결과 출력
        int resultLength = 0;
        for (int i = 0; i < length; i++) {
            if (bombs[i] != 0) resultLength++;
            else break;
        }

        System.out.println(resultLength);
        for (int i = 0; i < resultLength; i++) {
            System.out.println(bombs[i]);
        }
    }
}
