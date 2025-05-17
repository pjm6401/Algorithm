import java.util.Scanner;

public class Main {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         sum1(1, n);
    }

    public static void sum1(int i,int n){
        if(i>n) {
            System.out.println(sum);
            return;
        }
        sum +=i;
        i++;
        sum1(i,n);
    }
}