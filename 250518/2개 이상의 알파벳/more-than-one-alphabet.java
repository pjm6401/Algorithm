import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        printResult(A);
    }

    public static void printResult(String A){
        char checker = '1';
        int count = 0;
        for(int i =0; i<A.length();i++){
            if(checker != A.charAt(i)){
                count++;
                checker = A.charAt(i);
                if(count>=2){
                    break;
                }
            }
        }

        if(count>=2){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}