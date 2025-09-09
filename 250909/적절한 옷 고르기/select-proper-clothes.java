import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int [] dp = new int [m+1];
        int [] dpNum = new int [m+1];
        for(int i = 0; i<m; i++){
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i<n; i++){
            if(s[i] == 1){
                dpNum[0] = v[i];
                for(int j = 1; j<m; j++){
                    for(int k = 0; k<n; k++){
                        if(s[k]<=j && e[k]>=j){
                            if(Math.abs(dpNum[j-1]-v[k]) > dp[j]){
                                dpNum[j] = v[k];
                                dp[j] = Math.abs(dpNum[j-1]-v[k]);
                            }
                        }
                    } 
                }
            }
        }
        int sum = 0;
        for(int i : dp){
            if(i>0) sum+=i;
            
        }
        System.out.println(sum);
    }
}