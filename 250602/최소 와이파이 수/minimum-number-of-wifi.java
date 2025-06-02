import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] arrWifi = new int [n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int cnt = 0;
        for(int i = 0; i<n-1 ; i++){
            if(arr[i] == 1){
                cnt ++;
                
                i +=m;
            }
        }

        System.out.println(cnt);

    }
}