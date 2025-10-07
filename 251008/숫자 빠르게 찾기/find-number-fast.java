import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int ans = -1;
            int left = 0;
            int right = n-1;

            while(left<=right){
                 int mid = (left + right) / 2;
                if(arr[mid] == x){
                    ans = mid; // 또는 arr[mid]
                    break;
                } else if(arr[mid] > x){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if(ans != -1) ans++;
            System.out.println(ans);
        }
    }
}