import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int nTemp = n;
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            for(int j = n; j>0; j--){
                if(cnt%2==0){
                    System.out.print(i);
                    cnt ++;
                }
                else{
                    System.out.print(nTemp);
                    cnt ++;
                }
                
            }
            cnt = 0;
            nTemp--;
            System.out.println();
        }
    }
}