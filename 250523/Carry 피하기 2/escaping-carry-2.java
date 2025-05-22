import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = -1;

        for (int i = 0; i < n-2; i++) {
            for(int j=1; j<n-1;j++){
                for(int k=2; k<n; k++){
                    if(isCarry(arr[i],arr[j],arr[k])){
                        max = Math.max(max,arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }
        System.out.println(max);
    }


    public static boolean isCarry(int a, int b, int c){
        boolean flag = true;

        while(flag){
            if(a == 0 && b==0 && c==0){
                break;
            }
            if(a%10+b%10+c%10>=10){
                flag = false;
            }
            a/=10;
            b/=10;
            c/=10;
        }

        return flag;
    }
}