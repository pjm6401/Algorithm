import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int idx = 0;
        for(int i = 0; i<str.length()-1;i++){
            boolean flag = false;
            for(int j = i+1; j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }else{
                idx = i+1;
                break;
            }
        }

        System.out.println(idx);
    }
}