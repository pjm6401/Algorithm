import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<=n; i++){
            if(i != 1 && isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }

    public static boolean isPrime(int n){

        if(n==2){
            return true;
        }

        for(int i = n-1; i>1;i--){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
}