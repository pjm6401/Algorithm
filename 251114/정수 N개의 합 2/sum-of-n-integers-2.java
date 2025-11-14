import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int [] temp = new int [n+1];

        for(int i = 1; i<n; i++){
            temp[i] = temp[i-1] + arr[i];
        }

        for(int i = 1; i <= n - k + 1; i++)
            ans = Math.max(ans, getSum(i, i + k - 1));

        System.out.print(ans);
    }
    
}