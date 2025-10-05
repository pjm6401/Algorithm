import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n-k; i++){
            for(int j = i+1; j<=i+k; j++){
                if(arr[i] == arr[j])
                ans = Math.max(ans,arr[i]);
            }
        }
        System.out.println(ans);
    }
}