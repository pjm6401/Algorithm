import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){


            if(i!=0 && arr[i] == arr[i-1]){
                cnt++;
            }else{
                cnt =0;
            }

            if(cnt+1 > max){
                max = cnt+1;
            }
        }

        
        System.out.print(max);
        // Please write your code here.
    }
}