import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();


        boolean flag = true;

        while (flag){

            if(a.contains(b)){
                a = a.replace(b,"");
               
                
            }else{
               flag = false;
            }
        }

        System.out.print(a);
    }
}