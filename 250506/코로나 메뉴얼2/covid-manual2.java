import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String state[] = new String [3];
        int temp [] =new int [3];
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            state[i] = input[0];         // 'Y' 또는 'N'
            temp[i] = Integer.parseInt(input[1]); // 38, 36, 40 같은 숫자
        }

        int hospital[] = {0,0,0,0};


        for(int i =0; i<3; i++){

            if(state[i].equals("Y") &&  temp[i]>=37){
                hospital[0] +=1;
            }
            else if(state[i].equals("N") &&  temp[i]>=37){
                hospital[1] +=1;
            }
            else if(state[i].equals("Y") &&  temp[i]<37){
                hospital[2] +=1;
            }
            else{
                hospital[3] +=1;
            }
        }

        for(int i =0; i<hospital.length; i++){
            System.out.print(hospital[i]+" ");
        }
        if(hospital[0]>=2){
            System.out.print("E");
        }
    }
}