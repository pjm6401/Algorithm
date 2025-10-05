import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;

        for(int i =0; i<n; i++){
            int sum = 0;
            int cnt = 0;
            for(int j = i; j<n; j++){
                sum += arr[j];
                cnt ++;
                if(sum>=s){
                    min = Math.min(min,cnt);
                    break;
                }
            }
            
        }
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}