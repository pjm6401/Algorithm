import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=1000; i++){
            int cost = 0;

            for(int j =0; j<n; j++){
                int start = i;
                int end = i+17;
                if(arr[j]<start){
                    cost += (start - arr[j]) * (start - arr[j]);
                }else if(arr[j] > end){
                    cost += (arr[j] - end) * (arr[j] - end);
                }
            }
            min = Math.min(min,cost);
        }
        System.out.println(min);
    }
}