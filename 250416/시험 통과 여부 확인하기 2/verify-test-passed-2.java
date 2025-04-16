import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String [] student = new String[n];

        for (int i = 0; i <student.length; i++){
            String[] input = br.readLine().split(" ");

            student[i] = isPass(input);
        }
        printResult(student);
    }

    public static String isPass(String[] input){
        String flag = "pass";
        int sum = 0;
        for(String inputString : input){
            sum += Integer.parseInt(inputString);
        }

        return flagGenerate(sum/4);
    }

    public static String flagGenerate(int sum){
        if(sum>=60){
            return "pass";
        }else{
            return "fail";
        }
    }

    public static void printResult(String [] student){
        int passCnt = 0;

        for(String result : student){
            System.out.println(result);
            if(result.equals("pass")){
                passCnt ++;
            }
        }
        System.out.println(passCnt);
    }
}