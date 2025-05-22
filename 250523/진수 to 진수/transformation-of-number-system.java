import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        int num = 0;
        int [] digit = new int[100];
        for(int i = 0; i<N.length(); i++){
            num = num * A + Character.getNumericValue(N.charAt(i));
        }
        int cnt = 0;
        while(true){
            if(num<B){
                digit[cnt++] = num;
                break;
            }

            digit[cnt++] = num % B;

            num /=B;
        }
       
        for(int i = cnt - 1; i>=0;i--){
            System.out.print(digit[i]);
        }

    }
}