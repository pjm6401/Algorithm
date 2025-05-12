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

        for(int i =1; i<n; i++){
            if(isPlus(arr[i],arr[i-1])){
                cnt++;
            }else{
                if(cnt>max){
                    max = cnt;
                }
            }
        }

        if(max !=0){
            max = cnt;
        }
        System.out.println(max);
    }


    public static boolean isPlus(int x, int y){
        return x>y;
    }
}