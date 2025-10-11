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
        long left = 1;
        long right = Long.MAX_VALUE-1;
        long time = Long.MAX_VALUE;
        while(left<=right){
            long mid = (left+right)/2;

            if(isPossible(mid,arr,m)){
                time = Math.min(time,mid);
                right = mid-1;
                
            }else{
                left = mid +1;
            }
        }
        System.out.println(time);
    }


    public static boolean isPossible(long mid, int [] arr, int m){
        int lain = 1;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];

            if(sum>mid){
                sum = arr[i];
                lain++;
            }
        }

        return lain<=m;
    }
}