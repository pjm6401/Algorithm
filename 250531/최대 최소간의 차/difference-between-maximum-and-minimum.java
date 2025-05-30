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
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=10000; i++){
            int cost = 0;
            for(int j = 0; j<n;j++){
                int start = i;
                int end = i+k;
                if(arr[j]<start){
                    cost += Math.abs(arr[j]-start);
                }else if(arr[j]>end){
                    cost += Math.abs(arr[j]-end);
                }
            }

            min = Math.min(min,cost);
        }
        System.out.println(min);
    }
}