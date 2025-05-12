import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt =0;
        int max =0;

        if(n==1){
            cnt++;
        }else{
            for(int i =1; i<n; i++){
                if(isPlus(arr[i],arr[i-1])){
                    cnt++;
                }else{
                    if(cnt+1>max){
                        max = cnt+1;
                    }
                    cnt = 0;
                }
            }
        }

        

        if(max ==0 && n!=1){
            max = cnt+1;
        }else{
            max = cnt;
        }
        System.out.println(max);
    }


    public static boolean isPlus(int x, int y){
        return x>y;
    }
}