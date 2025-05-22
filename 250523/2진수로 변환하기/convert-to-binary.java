import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr= new int [20];
        int cnt = 0;
        while (true){
            if(n<2){
                arr[cnt++] = n;
                break;
            }

            arr[cnt++] = n%2;

            n /=2;
        }

         for(int i = cnt - 1; i >= 0; i--)
            System.out.print(arr[i]);
    }
}