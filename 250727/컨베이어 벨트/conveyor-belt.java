import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        int [] all = new int [2*n];
        for (int i = 0; i < n; i++) {
            all[i] = top[i];
        }
        for (int i = n-1; i >= 0; i--) {
            all[n+i] = bottom[i];
        }

        for(int i = 0; i<t; i++){
            int temp = all[2*n-1];
            for(int k = 2*n-1; k>=1; k--){
                all[k] = all[k-1];
            }
            all[0] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(all[i]+" ");
        }
        System.out.println();
        for (int i = n; i < 2*n; i++) {
            System.out.print(all[i]+" ");
        }
    }
}