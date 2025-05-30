import java.util.Scanner;
public class Main {

    static int k = 0;
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = Math.max(arr[0],arr[n-1]) ; i<=100; i++){
            if(maxInt(arr,i)){
                System.out.println(i);
                break;
            }
        }
       
    }

    public static boolean maxInt(int [] arr, int num){
        
        int idx = 0;

        for(int i = 0; i<n;i++){
            if(arr[i]<=num){
                if(i-idx>k){
                    return false;
                }
                idx = i;
            }
        }

        
        return true;
    }
}