import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] visit = new int[100000];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int j = 0;
        int ans = 0;
        for (int i = 0; i<n; i++) {
            visit[arr[i]] ++;

            while(j+1<n && visit[arr[j+1]] < 1){
                visit[arr[j+1]] ++;
                j++;
            }

            ans = Math.max(ans,j-i+1);
            
            visit[arr[i]] --;
        }

        System.out.println(ans);
    }
}