import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        if(isInBound(A,B,C)){
            int startMin = (11*24*60)+(11*60)+11;
            int endMin = (A*24*60)+(B*60)+C;

            System.out.println(endMin-startMin);
        }else{
            System.out.println(-1);
        }
        

    }

    public static boolean isInBound(int A, int B, int C){
        return ((A>=11) || (A==11 && B>=11) || (A==11 && B==11 && C>=11));

    }
}