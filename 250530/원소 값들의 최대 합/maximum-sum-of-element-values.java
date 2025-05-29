import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;

        for (int i = 1; i<=n; i++){
            int sum = 0;

            int [] arrTemp = new int[n+1];


            int start = arr[i];
            for(int j=0; j<m; j++){
                sum+=start;

     
                int next = arr[start];
                start = next;
                
            }
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }
}