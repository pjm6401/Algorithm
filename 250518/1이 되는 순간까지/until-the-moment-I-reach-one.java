import java.util.Scanner;
public class Main {

    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(result(n)); 
    }

    public static int result(int n){
        if(n==1){
            return 0;
        }
        if(n%2 == 0){
            
            return result(n/2)+1;
        }else{
            count++;
            return result(n/3)+1;
        }
    }
}