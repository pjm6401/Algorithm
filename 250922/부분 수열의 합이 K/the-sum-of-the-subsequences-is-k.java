import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        int[] temp = new int [n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i = 1; i<=n; i++){
            temp[i] = temp[i-1] +arr[i];
        }
        int ans = 0;
        for(int i = 1; i<=n;i++){
            for(int j =1; j<=n; j++){
                if(k == temp[j] - temp[i-1]) ans++;
            }
        }

        System.out.println(ans);
    }
}