import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int last = n*n;
        int cnt = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i%2!=0){
                    System.out.print(cnt+n-1-(j*2)+" ");
                    cnt++;
                }else{
                    System.out.print(cnt+" ");
                    cnt++;
                }
            }
            System.out.println();
        }
    }
}