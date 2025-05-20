import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Array(n)) ;

    }


    public static int Array(int n){
        if(n==1) return 2;
        if(n==2) return 4;

        return (Array(n-1) * Array(n-2))%100;
    }
}