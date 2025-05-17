import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(result(n - 1, arr));
    }

    // GCD 재귀
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // LCM 계산
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 배열의 LCM을 재귀적으로 구함
    public static int result(int n, int[] arr) {
        if (n == 0)
            return arr[0];
        return lcm(arr[n], result(n - 1, arr));
    }
}
