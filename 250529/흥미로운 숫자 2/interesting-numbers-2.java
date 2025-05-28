import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;
        for(int i = x; i<=y;i++){
            int n = i;
            int [] arr = new int [10];
            int digit = 0;
            while (n > 0){
                arr[n%10] ++;
                digit++;
                n /=10;
            }

            if(isMystery(arr,digit)) {
                cnt++;
            }
        }
        System.out.println(cnt);
        
    }
    public static boolean isMystery(int []arr,int digit){

            boolean flag = false;
            for(int i = 0; i<10; i++){
                if(arr[i] == digit -1) flag = true;
            }

            return flag;
        }
}