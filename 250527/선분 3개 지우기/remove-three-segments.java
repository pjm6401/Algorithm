import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        int [] count = new int [101];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();

            for(int j=a[i]; j<=b[i];j++){
                count[j] ++;
            }
        }

        int count2 = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] countTemp = Arrays.copyOf(count, count.length);

                    // i, j, k 번째 선분을 제거
                    for (int l = a[i]; l <= b[i]; l++) countTemp[l]--;
                    for (int l = a[j]; l <= b[j]; l++) countTemp[l]--;
                    for (int l = a[k]; l <= b[k]; l++) countTemp[l]--;

                    // 겹치는 구간이 있는지 확인
                    boolean flag = true; // << 이 위치 중요!
                    for (int l = 0; l < countTemp.length; l++) {
                        if (countTemp[l] >= 2) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) count2++;
                }
            }
        }

        System.out.println(count2);
    }
}