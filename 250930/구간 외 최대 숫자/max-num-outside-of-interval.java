import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int [] R = new int [n];
        int [] L = new int [n];
        L[0] = arr[0];
        for(int i = 1; i<n;i++){
            L[i] = Math.max(L[i-1],arr[i]);
        }
        R[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){ 
            R[i] = Math.max(R[i+1],arr[i]);
        }
        
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(Math.max(L[a-2], R[b]));
        }
        


    }
}