import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 1; i < n; i++){
            if(a[i]>b[i]){
                sum+=a[i]-b[i];
                a[i+1] += (a[i] - b[i]);
            }
        }
        System.out.print(sum);
    }
}