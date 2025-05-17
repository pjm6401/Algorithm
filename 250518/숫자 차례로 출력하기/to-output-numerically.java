import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print1(n);

    }

    public static void print1(int n){
        
        for(int i = 0; i<n;i++) System.out.print(i+1+" ");
        System.out.println();
        for(int i = n; i>0;i--) System.out.print(i+" ");
    }

}