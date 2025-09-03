import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean [] dp = new boolean[m+1];
        dp[0] = true;

        for(int i = 0; i<n; i++){
            for(int j = m; j>=1; j--){
                if(j>=arr[i]){
                    if(!dp[j-arr[i]]) continue;

                    dp[j] = true;
                }
            }
        }
        String ans = "No";
        if(dp[m]) ans = "Yes";
        System.out.println(ans);
    }
}