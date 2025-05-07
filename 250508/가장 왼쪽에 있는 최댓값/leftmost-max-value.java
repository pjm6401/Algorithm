import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String [] number = br.readLine().split(" ");

        int n = Integer.parseInt(br.readLine());

        String [] arrayString = br.readLine().split(" ");

        int max =calcMax(arrayString);

        int idx = 0;

        while (idx != 1){
            for(int i =0; i<n;i++){
                if(Integer.parseInt(arrayString[i])==max){
                    idx = i+1;
                    n = i+1;
                    max = calcMax(Arrays.copyOfRange(arrayString, 0, i));
                    System.out.print(idx+" ");
                    break;
                }
            }

        }
    }

    public static int calcMax(String [] arrayString){
        int max =0;

        for(int i =0; i<arrayString.length; i++){
            if(Integer.parseInt(arrayString[i])>max){
                max = Integer.parseInt(arrayString[i]);
            }
        }
        return max;
    }
}