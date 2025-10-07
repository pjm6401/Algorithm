import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < m; i++) B[i] = sc.nextInt();
        
        int cnt = 0;
        
        for(int k = 0; k<m; k++){
            int j = 0;
            boolean flag = true;
            for (int i = 0; i<m; i++){

                if(k==i) continue;

                while(j<n && A[j] != B[i]){
                    j++;
                }
                if(j == n){
                    flag=false;
                    break;
                }
            }
            if(flag) cnt++;
        }

        System.out.println(cnt);
    }
}