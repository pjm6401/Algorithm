import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [20];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        for(int i =4; i<=n; i++){
            arr[i] = 2*arr[i-1] + 2*arr[i-2];
        }

        System.out.println(arr[n]);
    }
}