import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){
           
            if(i%3==0){
                System.out.print(0+" ");
            }else if(is369(i)) {
                System.out.print(0+" ");
            }else{
                System.out.print(i+" ");
            }
        }
    }

    private static boolean is369(int n){

        String nStr = toString(n);
        
        if(nStr.contains("3") || nStr.contains("6") || nStr.contains("9")){
            return true;
        }
        return false;
    }

    private static String toString (int n ){
        return String.valueOf(n);
    }
}