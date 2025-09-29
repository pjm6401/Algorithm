import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int [] L = new int [n];
        int [] R = new int [n];

        for (int i = 1; i < n; i++) {

            L[i] = L[i-1] + Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
        }

        for (int i = n-2; i >=0 ; i--) {

            R[i] = R[i+1] + Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i<n-1; i++){
            ans = Math.min(ans, L[i-1] + R[i+1] +  Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]));
        }

        System.out.println(ans);
    }
}