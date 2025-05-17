import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(result(n-1,arr));
    }

    public static int result (int n,int [] arr){
        if(n==0){
            return arr[0];
        }
        if(n==1){
            if(arr[n]%arr[n-1] ==0 || arr[n-1]%arr[n] ==0){
                return Math.min(arr[n],arr[n-1]);
            }else{
                return arr[1] * arr[0];
            }
        }
        
        
        if(arr[n]%arr[n-1] ==0 || arr[n-1]%arr[n] ==0){
            return Math.min(arr[n],arr[n-1])* result(n-1,arr);
        }else{
            return arr[n-1]* result(n-1,arr);
        }
    }
}