import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        int array[] = new int [n];

        String[] input2 = br.readLine().split(" ");
        for(int i =0;i<n;i++){
            array[i] = Integer.parseInt(input2[i]);
        }

        for(int i =0; i<q; i++){
            String[] input3 = br.readLine().split(" ");
            if(input3[0].equals("1")){
                System.out.println(array[Integer.parseInt(input3[1])-1]);
            }
            else if (input3[0].equals("2")){
                int count = 0;

                for(int j =0; j<array.length;j++){
                    if(array[j] == Integer.parseInt(input3[1])){
                        count = j+1;
                        break;
                    }

                }
                System.out.println(count);
            }else{
                int start = Integer.parseInt(input3[1]);
                int end = Integer.parseInt(input3[2]);

                for(int k = start-1; k<end;k++){
                    System.out.print(array[k] +" ");
                }
                System.out.println();
            }
        }
    }
}