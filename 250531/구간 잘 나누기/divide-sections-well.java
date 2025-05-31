import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        // 한 구간에 들어오는 최소 1, 구간에 들어오는 최대 n - m +1 , 가장 고르게 분포 n/m + n%m 

        int length = n/m + n%m;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i =0; i<=n-length; i++){
            int sum = 0;
            for(int j = i; j<i+length; j++){
                sum += nums[j];
            }
            max= Math.max (max, sum);
            min= Math.min(min,max);
        }
        System.out.println(min);
    }
}