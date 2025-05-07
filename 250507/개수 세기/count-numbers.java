import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        

        int count = 0;
        String [] input2 = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            if(m == Integer.parseInt(input2[i])){
                count++;
            }
        }
        System.out.println(count);
    }
}