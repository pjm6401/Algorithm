import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int min = Integer.MAX_VALUE;

        if(A.length()==1){
            System.out.println(2);
            return;
        }

        String temp = A;

        for(int i = 0; i < A.length(); i++){
            temp = shift(temp);
            min = Math.min(min,countString(temp));
        }

        System.out.println(min);
    }

    public static String shift(String s){
        char[] stringArray = s.toCharArray();

        char temp = stringArray[s.length()-1];

        for(int i = s.length()-1; i >= 1; i--){
            stringArray[i] = stringArray[i-1];
        }
        stringArray[0] = temp;

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            sb.append(stringArray[i]);
        }

        return sb.toString();
        
    }

    public static int countString (String s){
        char[] stringArray = s.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++){
            if(stringArray[i] == stringArray[i + 1]){
                count++;
            } else {
                sb.append(stringArray[i]).append(count);
                count = 1;
            }
        }
        sb.append(stringArray[s.length() - 1]).append(count);
        return sb.toString().length();
    }
}