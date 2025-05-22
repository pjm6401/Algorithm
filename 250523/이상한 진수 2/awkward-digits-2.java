import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int max = 0;
        char [] aString = a.toCharArray();
        for(int i = 0; i<aString.length; i++){
            char original = aString[i];

            aString[i] = aString[i] == '0'? '1' : '0';

            int digit = conversionString(aString);

            max = Math.max(max,digit);
            aString[i] = original;
        }

        System.out.println(max);
    }

    public static int conversionString(char[] aString){
        int num = 0;
        for(int i = 0; i<aString.length; i++){
            num = num * 2 + Character.getNumericValue(aString[i]);
        } 

        return num;
    }
}