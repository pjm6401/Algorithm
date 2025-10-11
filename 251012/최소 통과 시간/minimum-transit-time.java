import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++)
            arr[i] = sc.nextInt();
        long left = 1;
        long right = (long)1e14;
        long min = 0;

        while(left<=right){
            long mid = (left+right)/2;

            if(isPossible(mid,n,arr)){
                min = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(min);
    }

    public static boolean isPossible(long mid,int n,int[] arr){
        long cnt = 0;

        for(int i = 0; i<arr.length; i++){
            cnt += mid/arr[i];
        }

        return cnt>=n;
    }
}