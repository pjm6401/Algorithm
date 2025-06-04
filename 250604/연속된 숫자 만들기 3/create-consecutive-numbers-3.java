import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        Arrays.sort(arr); // 정렬하여 순서를 맞춘다

        int leftGap = arr[1] - arr[0];
        int rightGap = arr[2] - arr[1];

        // 가장 큰 gap 쪽으로 수를 이동시키면 됨
        System.out.println(Math.max(leftGap, rightGap) - 1);
    }
}
