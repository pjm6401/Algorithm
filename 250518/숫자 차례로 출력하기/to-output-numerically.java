import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print3 (1,n);
        System.out.println();
        print2 (n);
        
    }

    public static void print1(int n){
        
        for(int i = 0; i<n;i++) System.out.print(i+1+" ");
        System.out.println();
        for(int i = n; i>0;i--) System.out.print(i+" ");
    }


     public static void print2(int n){
        
        if(n==0)return;

        System.out.print(n+" ");
        print2(n-1);
    }

    public static void print3(int i,int n){
        
        if(i>n)return;

        System.out.print(i+" ");
        print3(i+1,n);
    }
}