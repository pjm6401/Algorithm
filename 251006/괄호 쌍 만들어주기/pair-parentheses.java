import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        char [] str = A.toCharArray();

        int [] L = new int[str.length];
        int [] R = new int[str.length];

        for(int i = str.length-2; i>=0; i--){
            if(str[i] == ')' && str[i] == str[i+1]){
                R[i] = R[i+1]+1;
            }else{
                R[i] = R[i+1];
            }
        }
        long ans = 0;

        for(int i =0; i<str.length-2; i++){
            if(str[i] == '(' && str[i] == str[i+1]){
                ans += R[i+2];
            }
        }
        System.out.println(ans);
    }
}