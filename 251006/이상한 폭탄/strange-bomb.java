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
        for(int i = 0; i < n-1; i++){

            int limit = i+k;
            limit = Math.min(limit, n-1);
            for(int j = i+1; j<=limit; j++){
                if(arr[i] == arr[j])
                ans = Math.max(ans,arr[i]);
            }
        }

        if(ans == 0 ) ans = -1;
        System.out.println(ans);
    }
}