import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        for(int i = 1; i<=k; i++){
            for(int j = 1; j<=k; j++){
                System.out.println(i+" "+j);
            }
        }
    }
}