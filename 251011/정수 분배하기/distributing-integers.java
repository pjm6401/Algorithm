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

        int left = 1;
        int right = 100000;
        int max =0;
        while(left<=right){
            int mid = (left+right)/2;

            if(calc(arr,mid,m) >= m){
                
                left = mid+1;
                max = Math.max(max,mid);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(max);
    }

    public static int calc(int [] arr, int n, int m){
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            
                count += arr[i] / n;
            
        }


        return count;
    }
}