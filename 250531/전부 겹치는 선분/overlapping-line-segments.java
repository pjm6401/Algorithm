import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [101];
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int j = a; j<=b; j++){
                arr[j]++;
            }
        }
        String ans ="No";
        for(int i = 0; i<=100; i++){
            if(arr[i]==n){
                ans = "Yes";
                break;
            }
        }

        System.out.println(ans);
    }
}