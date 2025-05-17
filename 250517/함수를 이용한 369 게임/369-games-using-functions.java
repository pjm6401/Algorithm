import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.
        int count = 0;
        for(int i = A; i<=B; i++){
            if(isMagicNumber1(i) || isMagicNumber2(i)){
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isMagicNumber1(int n){
        return (n%3 == 0);
    }

    public static boolean isMagicNumber2(int n){
        String nString = Integer.toString(n);

        boolean flag = false;

        for(int i =0; i<nString.length(); i++){
            char target = nString.charAt(i);
            if(target == '3' || target == '6' || target == '9'){
                flag = true;
                break;
            }
        }

        return flag;
    }
    
}