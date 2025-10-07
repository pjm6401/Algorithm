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
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int ans = -1;
            int left = 0;
            int rigth = n-1;
            int idx = n;
            while(left<=rigth){
                int mid = (left+rigth)/2;

                if(arr[mid]>=x){
                    rigth = mid -1;
                    if(arr[mid] == x)
                    idx = Math.min(idx,mid);
                }else{
                    left = mid +1;
                }
            }

            if(idx != n) ans = idx+1;
            System.out.println(ans);
        }
        
    }
}