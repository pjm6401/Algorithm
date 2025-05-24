import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int max = 0;

        for(int i = 0; i< n-2; i++){
            int sum = arr[i]+arr[i+1]+arr[i+2];

            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}