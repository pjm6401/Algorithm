import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        for(int j = 1; j<=9; j++){
            for(int i = b; i>=a; i=i-2){
                System.out.print(i+" * "+j+" = "+i*j);
                if(i!=a){
                    System.out.print(" / ");
                }
            } 
            System.out.println(); 
        }
                
    }
}