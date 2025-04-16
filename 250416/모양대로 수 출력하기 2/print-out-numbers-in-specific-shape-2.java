import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 2;
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(cnt+" ");
                cnt +=2;
                if(cnt >=10){
                    cnt = 2;
                }
            }
            System.out.println();
        }
    }
}