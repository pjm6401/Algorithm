import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String [] input = br.readLine().split(" ");
        int max = 0;

        for(int i =input.length-1;i>0;i--){
            for(int j = i-1;j>-1;j--){
                if((Integer.parseInt(input[i])-Integer.parseInt(input[j]))>max){
                    max = Integer.parseInt(input[i])-Integer.parseInt(input[j]);
                }
            }

        }
        System.out.print(max);
    }
}