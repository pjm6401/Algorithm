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
        

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for(int j=i+1;j<n;j++){
                sum += (j-i)*a[j];
            }
            for(int j=0;j<i;j++){
                sum += (i-j)*a[j];
            }
            min = Math.min(min,sum);
        }

        System.out.println(min);
    }
}