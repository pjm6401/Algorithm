import java.util.Scanner;
public class Main {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        result(n);
    }

    public static void result(int n){
        if(n==1){
            System.out.print(count);
            return;
        }
        if(n%2 == 0){
            count++;
            result(n/2);
        }else{
            count++;
            result(n/3);
        }
    }
}