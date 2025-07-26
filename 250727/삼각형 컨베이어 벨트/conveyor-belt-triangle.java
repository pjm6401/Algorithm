import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        int[] a = new int[3*n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[n+i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[2*n+i] = sc.nextInt();
        }
        for(int i = 0; i<t; i++){
            int temp = a[3*n-1];
            for(int k = 3*n-1; k>=1; k--){
                a[k] = a[k-1];
            }
            a[0] = temp;
        }
        for(int i = 0; i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int i = n; i<2*n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int i = 2*n; i<3*n;i++){
            System.out.print(a[i]+" ");
        }
    }
}