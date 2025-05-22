import java.util.Scanner;
public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int total = 0;
        for (int i = 0; i < n; i++){
            total += a[i];
        }

        for (int i = 0; i < n-1; i++) {
            int numA = a[i];
            for(int j = i+1; j < n; j++){
                int numB = a[j];
                System.out.println(min);
                min = Math.min(min,Math.abs(total - (total-numA-numB)));
            }
        }

        System.out.println(min);
    }
}