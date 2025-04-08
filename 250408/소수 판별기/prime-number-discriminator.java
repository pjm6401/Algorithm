import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(isPrime(n)){
            System.out.print("P");
        }else{
            System.out.print("C");
        }
    }

    private static boolean isPrime(int n){

        boolean flag = true;

        if(n==2){
            return flag;
        }

        for(int i =2; i<n; i++){
            if(n%i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}