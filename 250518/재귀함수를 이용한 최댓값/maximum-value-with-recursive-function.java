import java.util.Scanner;
public class Main {

    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(result(n-1,arr));
    }

    public static int result(int n, int[] arr){
        if (n==0){
            return arr[0];
        }

        return Math.max(arr[n],result(n-1,arr));
    }
}