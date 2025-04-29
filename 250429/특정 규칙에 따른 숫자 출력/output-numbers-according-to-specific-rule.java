import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        for(int i =0; i<n; i++){
            for (int j = 0; j<n; j++){
                if(i>j){
                    System.out.print("  ");
                }else{
                    System.out.print(cnt+" ");
                    cnt ++;
                    if(cnt>=10){
                        cnt = 1;
                    }
                }
            }
            System.out.println();
        }
    }
}