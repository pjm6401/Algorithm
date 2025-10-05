import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int j = 0;
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            while(j<n && cnt<k){
                if(arr[j] == 1) cnt ++;
                j++;
            }
            if (cnt >= k) {
                ans = Math.min(ans, j - i);
            }
            if(arr[i] == 1) cnt --;
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}