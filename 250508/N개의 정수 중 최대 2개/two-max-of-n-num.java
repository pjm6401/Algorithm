import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] number = br.readLine().split(" ");

        int n = Integer.parseInt(number[0]);

        String [] arrayString = br.readLine().split(" ");


        String temp;

        for(int i =0; i<n-1;i++){
            for(int j=1; j<n; j++){
                if(Integer.parseInt(arrayString[j-1])<Integer.parseInt(arrayString[j])){
                    temp = arrayString[j];
                    arrayString[j] = arrayString[j-1];
                    arrayString[j-1] = temp;
                }
                
            }
        }

        for(int i =0; i<2;i++){
            System.out.print(arrayString[i]+" ");
        }
    }
}