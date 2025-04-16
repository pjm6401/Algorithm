import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

       
        for(int j =n; j>0; j--){
            printStart(j);
        }
            
    }


    public static void printStart(int n){
        for(int i =0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print("*");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}