import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);

        String [] inputN1 = br.readLine().split(" ");
        String [] inputN2 = br.readLine().split(" ");

        int [] arrayN1 = new int [n1];
        int [] arrayN2 = new int [n2];

        for(int i = 0; i<inputN1.length;i++){
            arrayN1[i] = Integer.parseInt(inputN1[i]);
        }
         for(int i = 0; i<inputN2.length;i++){
            arrayN2[i] = Integer.parseInt(inputN2[i]);
        }

        String flag = "No";
        for(int i =0; i<=n1-n2;i++){
            for(int j=0;j<n2;j++){
                if(arrayN1[j+i] == arrayN2[j]){
                    /*System.out.println("i : "+i);
                    System.out.println("arrayN1 : "+arrayN1[j+i]);
                    System.out.println("arrayN2 : "+arrayN2[j]);
                    System.out.println("j : "+j);*/
                    flag = "Yes";
                }else{
                    /*System.out.println("i : "+i);
                    System.out.println("arrayN1 : "+arrayN1[j+i]);
                    System.out.println("arrayN2 : "+arrayN2[j]);
                    System.out.println("j : "+j);*/
                    flag = "No";
                    break;
                }
            }
            //System.out.println("Result: "+ flag);
            if(flag.equals("Yes")){
                break;
            }            
        }
        System.out.println(flag);
    }
}