import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i<n-1; i++){
            sum += arr[i];
            for(int j = i+1; j<n;j++){
                sum+=arr[j];
                if(sum <= k) cnt ++;
                sum-=arr[j];
            }
            sum -= arr[i];
        }
        System.out.println(cnt);
    }
}