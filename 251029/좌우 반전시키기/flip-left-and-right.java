import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0; 
        for(int i=1; i<arr.length; i++){
            if(arr[i-1]==0){
                cnt++;
                if(arr[i-1]==1){
                    arr[i-1] = 0;
                }else{
                    arr[i-1] = 1;
                }

                if(arr[i]==1){
                    arr[i] = 0;
                }else{
                    arr[i] = 1;
                }
                if(i+1<N){
                    if(arr[i+1]==1){
                    arr[i+1] = 0;
                    }else{
                        arr[i+1] = 1;
                    }
                }
            }
        }
        boolean flag = true;

        for(int i=0; i<arr.length; i++){
            if(arr[i] ==0){
                flag= false;
                break;
            }
        }

        if(flag){
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }
    }
}