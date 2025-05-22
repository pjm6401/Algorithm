import java.util.Scanner;
public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int total = 0;
        for (int i = 0; i < n; i++){
            total += a[i];
        }

        for (int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++){
                min = Math.min(min,Math.abs(s - (total-a[i]-a[j])));
            }
        }

        System.out.println(min);
    }
}